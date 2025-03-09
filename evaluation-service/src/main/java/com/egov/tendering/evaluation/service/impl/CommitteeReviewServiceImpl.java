package com.egov.tendering.evaluation.service.impl;

import com.egov.tendering.evaluation.client.UserClient;
import com.egov.tendering.evaluation.dal.dto.CommitteeReviewDTO;
import com.egov.tendering.evaluation.dal.dto.ReviewRequest;
import com.egov.tendering.evaluation.dal.mapper.CommitteeReviewMapper;
import com.egov.tendering.evaluation.dal.model.CommitteeReview;
import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import com.egov.tendering.evaluation.dal.repository.CommitteeReviewRepository;
import com.egov.tendering.evaluation.event.EvaluationEventPublisher;
import com.egov.tendering.evaluation.exception.ReviewNotFoundException;
import com.egov.tendering.evaluation.service.CommitteeReviewService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommitteeReviewServiceImpl implements CommitteeReviewService {

    private final CommitteeReviewRepository reviewRepository;
    private final CommitteeReviewMapper reviewMapper;
    private final EvaluationEventPublisher eventPublisher;
    private final UserClient userClient;

    @Override
    @Transactional
    public CommitteeReviewDTO createReview(Long tenderId, ReviewRequest request, Long committeeMemberId) {
        log.info("Creating review for tender ID: {} by committee member ID: {}", tenderId, committeeMemberId);

        // Check if review already exists
        reviewRepository.findByTenderIdAndCommitteeMemberId(tenderId, committeeMemberId)
                .ifPresent(review -> {
                    throw new IllegalStateException("Review already exists for this tender and committee member");
                });

        CommitteeReview review = new CommitteeReview();
        review.setTenderId(tenderId);
        review.setCommitteeMemberId(committeeMemberId);
        review.setStatus(request.getStatus());
        review.setComments(request.getComments());

        review = reviewRepository.save(review);

        // Publish event
        eventPublisher.publishReviewCreatedEvent(review);

        // Check if all approvals are in
        if (isEvaluationApprovedByCommittee(tenderId)) {
            eventPublisher.publishTenderEvaluationApprovedEvent(tenderId);
        }

        return enrichReviewDTO(reviewMapper.toDto(review));
    }

    @Override
    public CommitteeReviewDTO getReviewById(Long reviewId) {
        log.info("Getting review by ID: {}", reviewId);

        CommitteeReview review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        return enrichReviewDTO(reviewMapper.toDto(review));
    }

    @Override
    @Transactional
    public CommitteeReviewDTO updateReview(Long reviewId, ReviewRequest request) {
        log.info("Updating review ID: {} with status: {}", reviewId, request.getStatus());

        CommitteeReview review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        ReviewStatus oldStatus = review.getStatus();
        review.setStatus(request.getStatus());
        review.setComments(request.getComments());

        review = reviewRepository.save(review);

        // Publish event
        eventPublisher.publishReviewUpdatedEvent(review, oldStatus);

        // Check if all approvals are in after status update
        if (isEvaluationApprovedByCommittee(review.getTenderId())) {
            eventPublisher.publishTenderEvaluationApprovedEvent(review.getTenderId());
        }

        return enrichReviewDTO(reviewMapper.toDto(review));
    }

    @Override
    @Transactional
    public void deleteReview(Long reviewId) {
        log.info("Deleting review ID: {}", reviewId);

        CommitteeReview review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        // Publish event before deletion
        eventPublisher.publishReviewDeletedEvent(review);

        reviewRepository.delete(review);
    }

    @Override
    public List<CommitteeReviewDTO> getReviewsByTender(Long tenderId) {
        log.info("Getting reviews for tender ID: {}", tenderId);

        List<CommitteeReview> reviews = reviewRepository.findByTenderId(tenderId);

        return enrichReviewDTOs(reviewMapper.toDtoList(reviews));
    }

    @Override
    public List<CommitteeReviewDTO> getReviewsByTenderAndStatus(Long tenderId, ReviewStatus status) {
        log.info("Getting reviews for tender ID: {} with status: {}", tenderId, status);

        List<CommitteeReview> reviews = reviewRepository.findByTenderIdAndStatus(tenderId, status);

        return enrichReviewDTOs(reviewMapper.toDtoList(reviews));
    }

    @Override
    public List<CommitteeReviewDTO> getReviewsByCommitteeMember(Long committeeMemberId) {
        log.info("Getting reviews by committee member ID: {}", committeeMemberId);

        List<CommitteeReview> reviews = reviewRepository.findByCommitteeMemberId(committeeMemberId);

        return enrichReviewDTOs(reviewMapper.toDtoList(reviews));
    }

    @Override
    public CommitteeReviewDTO getReviewByTenderAndCommitteeMember(Long tenderId, Long committeeMemberId) {
        log.info("Getting review for tender ID: {} and committee member ID: {}", tenderId, committeeMemberId);

        CommitteeReview review = reviewRepository.findByTenderIdAndCommitteeMemberId(tenderId, committeeMemberId)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found for tender ID: " +
                        tenderId + " and committee member ID: " + committeeMemberId));

        return enrichReviewDTO(reviewMapper.toDto(review));
    }

    @Override
    public boolean isEvaluationApprovedByCommittee(Long tenderId) {
        // Count reviews with APPROVED status
        long approvedCount = reviewRepository.countByTenderIdAndStatus(tenderId, ReviewStatus.APPROVED);

        // Count total reviews
        long totalCount = reviewRepository.findByTenderId(tenderId).size();

        // If no reviews, not approved
        if (totalCount == 0) {
            return false;
        }

        // All members must approve
        return approvedCount == totalCount;
    }

    // Helper method to enrich review DTO with committee member name
    private CommitteeReviewDTO enrichReviewDTO(CommitteeReviewDTO reviewDTO) {
        try {
            String memberName = userClient.getUsernameById(reviewDTO.getCommitteeMemberId());
            reviewDTO.setCommitteeMemberName(memberName);
        } catch (Exception e) {
            log.warn("Failed to get committee member name for ID: {}", reviewDTO.getCommitteeMemberId());
            reviewDTO.setCommitteeMemberName("Unknown");
        }
        return reviewDTO;
    }

    // Helper method to enrich a list of review DTOs
    private List<CommitteeReviewDTO> enrichReviewDTOs(List<CommitteeReviewDTO> reviewDTOs) {
        return reviewDTOs.stream()
                .map(this::enrichReviewDTO)
                .collect(Collectors.toList());
    }
}