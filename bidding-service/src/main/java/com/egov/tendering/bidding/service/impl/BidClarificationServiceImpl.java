package com.egov.tendering.bidding.service.impl;

import com.egov.tendering.bidding.dal.dto.BidClarificationDTO;
import com.egov.tendering.bidding.dal.mapper.BidClarificationMapper;
import com.egov.tendering.bidding.dal.model.Bid;
import com.egov.tendering.bidding.dal.model.BidClarification;
import com.egov.tendering.bidding.dal.model.BidStatus;
import com.egov.tendering.bidding.dal.model.ClarificationStatus;
import com.egov.tendering.bidding.dal.repository.BidRepository;
import com.egov.tendering.bidding.dal.repository.BidClarificationRepository;
import com.egov.tendering.bidding.event.BidEventPublisher;
import com.egov.tendering.bidding.exception.InvalidBidStateException;
import com.egov.tendering.bidding.exception.ResourceNotFoundException;
import com.egov.tendering.bidding.exception.AccessDeniedException;
import com.egov.tendering.bidding.service.BidClarificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BidClarificationServiceImpl implements BidClarificationService {

    private final BidClarificationRepository clarificationRepository;
    private final BidRepository bidRepository;
    private final BidClarificationMapper clarificationMapper;
    private final BidEventPublisher eventPublisher;

    @Override
    @Transactional(readOnly = true)
    public List<BidClarificationDTO> getClarificationsByBidId(Long bidId) {
        log.info("Fetching clarifications for bid ID: {}", bidId);
        List<BidClarification> clarifications = clarificationRepository.findByBidId(bidId);
        return clarificationMapper.toDtoList(clarifications);
    }

    @Override
    @Transactional
    public BidClarificationDTO requestClarification(Long bidId, String question, Long evaluatorId, int daysToRespond) {
        log.info("Requesting clarification for bid ID: {} by event ID: {}", bidId, evaluatorId);

        // Fetch and validate bid
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", bidId));
        if (bid.getStatus() != BidStatus.SUBMITTED && bid.getStatus() != BidStatus.UNDER_EVALUATION) {
            throw new InvalidBidStateException("Clarifications can only be requested for SUBMITTED or UNDER_EVALUATION bids");
        }

        // Create clarification
        BidClarification clarification = BidClarification.builder()
                .bid(bid)
                .question(question)
                .requestedBy(evaluatorId)
                .status(ClarificationStatus.PENDING)
                .deadline(LocalDateTime.now().plusDays(daysToRespond))
                .build();

        // Save and notify
        clarification = clarificationRepository.save(clarification);
        eventPublisher.publishClarificationRequestedEvent(bid, clarification);
        log.info("Clarification ID: {} requested for bid ID: {}", clarification.getId(), bidId);
        return clarificationMapper.toDto(clarification);
    }

    @Override
    @Transactional
    public BidClarificationDTO respondToClarification(Long clarificationId, String response, Long tendererId) {
        log.info("Responding to clarification ID: {} by tenderer ID: {}", clarificationId, tendererId);

        // Fetch and validate clarification
        BidClarification clarification = clarificationRepository.findById(clarificationId)
                .orElseThrow(() -> new ResourceNotFoundException("BidClarification", "id", clarificationId));

        // Verify tenderer ownership
        Bid bid = clarification.getBid();
        if (!bid.getTendererId().equals(tendererId)) {
            throw new AccessDeniedException("You don’t have permission to respond to this clarification");
        }

        // Check status and deadline
        if (clarification.getStatus() != ClarificationStatus.PENDING) {
            throw new InvalidBidStateException("Can only respond to PENDING clarifications");
        }
        if (LocalDateTime.now().isAfter(clarification.getDeadline())) {
            clarification.setStatus(ClarificationStatus.EXPIRED);
            clarificationRepository.save(clarification);
            throw new InvalidBidStateException("The deadline for this clarification has passed");
        }

        // Update with response
        clarification.setResponse(response);
        clarification.setRespondedAt(LocalDateTime.now());
        clarification.setStatus(ClarificationStatus.RESPONDED);

        // Save and notify
        clarification = clarificationRepository.save(clarification);
        eventPublisher.publishClarificationRespondedEvent(clarification);
        log.info("Clarification ID: {} responded for bid ID: {}", clarificationId, bid.getId());
        return clarificationMapper.toDto(clarification);
    }

    @Override
    @Transactional
    public void expireClarifications(Long bidId) {
        log.info("Expiring clarifications for bid ID: {}", bidId);

        // Fetch and validate bid
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bid", "id", bidId));

        // Find and update expired clarifications
        List<BidClarification> clarifications = clarificationRepository.findByBidIdAndStatus(bid.getId(), ClarificationStatus.PENDING);
        LocalDateTime now = LocalDateTime.now();
        clarifications.stream()
                .filter(clar -> now.isAfter(clar.getDeadline()))
                .forEach(clar -> {
                    clar.setStatus(ClarificationStatus.EXPIRED);
                    log.info("Clarification ID: {} expired for bid ID: {}", clar.getId(), bidId);
                });

        clarificationRepository.saveAll(clarifications);
    }
}