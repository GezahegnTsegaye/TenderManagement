package com.egov.tendering.evaluation.event;

import com.egov.tendering.evaluation.dal.dto.AllocationResultDTO;
import com.egov.tendering.evaluation.dal.dto.TenderRankingDTO;
import com.egov.tendering.evaluation.dal.model.CommitteeReview;
import com.egov.tendering.evaluation.dal.model.Evaluation;
import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Component for publishing evaluation-related events to Kafka topics
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class EvaluationEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.topics.evaluation-created}")
    private String evaluationCreatedTopic;

    @Value("${app.kafka.topics.evaluation-updated}")
    private String evaluationUpdatedTopic;

    @Value("${app.kafka.topics.evaluation-status-changed}")
    private String evaluationStatusChangedTopic;

    @Value("${app.kafka.topics.evaluation-deleted}")
    private String evaluationDeletedTopic;

    @Value("${app.kafka.topics.tender-evaluation-completed}")
    private String tenderEvaluationCompletedTopic;

    @Value("${app.kafka.topics.tender-evaluation-approved}")
    private String tenderEvaluationApprovedTopic;

    @Value("${app.kafka.topics.review-created}")
    private String reviewCreatedTopic;

    @Value("${app.kafka.topics.review-updated}")
    private String reviewUpdatedTopic;

    @Value("${app.kafka.topics.review-deleted}")
    private String reviewDeletedTopic;

    /**
     * Publishes an event when a new evaluation is created
     */
    public void publishEvaluationCreatedEvent(Evaluation evaluation) {
        EvaluationCreatedEvent event = new EvaluationCreatedEvent(
                evaluation.getId(),
                evaluation.getTenderId(),
                evaluation.getBidId(),
                evaluation.getEvaluatorId(),
                evaluation.getStatus(),
                evaluation.getOverallScore(),
                LocalDateTime.now()
        );

        log.info("Publishing evaluation created event for evaluation ID: {}", evaluation.getId());
        kafkaTemplate.send(evaluationCreatedTopic, evaluation.getId().toString(), event);
    }

    /**
     * Publishes an event when an evaluation is updated
     */
    public void publishEvaluationUpdatedEvent(Evaluation evaluation) {
        EvaluationUpdatedEvent event = new EvaluationUpdatedEvent(
                evaluation.getId(),
                evaluation.getTenderId(),
                evaluation.getBidId(),
                evaluation.getEvaluatorId(),
                evaluation.getStatus(),
                evaluation.getOverallScore(),
                LocalDateTime.now()
        );

        log.info("Publishing evaluation updated event for evaluation ID: {}", evaluation.getId());
        kafkaTemplate.send(evaluationUpdatedTopic, evaluation.getId().toString(), event);
    }

    /**
     * Publishes an event when an evaluation's status changes
     */
    public void publishEvaluationStatusChangedEvent(Evaluation evaluation, EvaluationStatus oldStatus) {
        EvaluationStatusChangedEvent event = new EvaluationStatusChangedEvent(
                evaluation.getId(),
                evaluation.getTenderId(),
                evaluation.getBidId(),
                evaluation.getEvaluatorId(),
                oldStatus,
                evaluation.getStatus(),
                LocalDateTime.now()
        );

        log.info("Publishing evaluation status changed event for evaluation ID: {}", evaluation.getId());
        kafkaTemplate.send(evaluationStatusChangedTopic, evaluation.getId().toString(), event);
    }

    /**
     * Publishes an event when an evaluation is deleted
     */
    public void publishEvaluationDeletedEvent(Evaluation evaluation) {
        EvaluationDeletedEvent event = new EvaluationDeletedEvent(
                evaluation.getId(),
                evaluation.getTenderId(),
                evaluation.getBidId(),
                evaluation.getEvaluatorId(),
                LocalDateTime.now()
        );

        log.info("Publishing evaluation deleted event for evaluation ID: {}", evaluation.getId());
        kafkaTemplate.send(evaluationDeletedTopic, evaluation.getId().toString(), event);
    }

    /**
     * Publishes an event when a tender evaluation is completed with rankings and allocations
     */
    public void publishTenderEvaluationCompletedEvent(
            Long tenderId,
            String tenderTitle,
            List<TenderRankingDTO> rankings,
            List<AllocationResultDTO> allocations) {

        TenderEvaluationCompletedEvent event = new TenderEvaluationCompletedEvent(
                tenderId,
                tenderTitle,
                rankings,
                allocations,
                LocalDateTime.now()
        );

        log.info("Publishing tender evaluation completed event for tender ID: {}", tenderId);
        kafkaTemplate.send(tenderEvaluationCompletedTopic, tenderId.toString(), event);
    }

    /**
     * Publishes an event when a tender evaluation is approved by the committee
     */
    public void publishTenderEvaluationApprovedEvent(Long tenderId) {
        TenderEvaluationApprovedEvent event = new TenderEvaluationApprovedEvent(
                tenderId,
                LocalDateTime.now()
        );

        log.info("Publishing tender evaluation approved event for tender ID: {}", tenderId);
        kafkaTemplate.send(tenderEvaluationApprovedTopic, tenderId.toString(), event);
    }

    /**
     * Publishes an event when a new committee review is created
     */
    public void publishReviewCreatedEvent(CommitteeReview review) {
        ReviewCreatedEvent event = new ReviewCreatedEvent(
                review.getId(),
                review.getTenderId(),
                review.getCommitteeMemberId(),
                review.getStatus(),
                LocalDateTime.now()
        );

        log.info("Publishing review created event for review ID: {}", review.getId());
        kafkaTemplate.send(reviewCreatedTopic, review.getId().toString(), event);
    }

    /**
     * Publishes an event when a committee review is updated
     */
    public void publishReviewUpdatedEvent(CommitteeReview review, ReviewStatus oldStatus) {
        ReviewUpdatedEvent event = new ReviewUpdatedEvent(
                review.getId(),
                review.getTenderId(),
                review.getCommitteeMemberId(),
                oldStatus,
                review.getStatus(),
                LocalDateTime.now()
        );

        log.info("Publishing review updated event for review ID: {}", review.getId());
        kafkaTemplate.send(reviewUpdatedTopic, review.getId().toString(), event);
    }

    /**
     * Publishes an event when a committee review is deleted
     */
    public void publishReviewDeletedEvent(CommitteeReview review) {
        ReviewDeletedEvent event = new ReviewDeletedEvent(
                review.getId(),
                review.getTenderId(),
                review.getCommitteeMemberId(),
                LocalDateTime.now()
        );

        log.info("Publishing review deleted event for review ID: {}", review.getId());
        kafkaTemplate.send(reviewDeletedTopic, review.getId().toString(), event);
    }
}