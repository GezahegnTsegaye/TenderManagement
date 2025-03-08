package com.egov.tendering.bidding.event;

import com.egov.tendering.bidding.dal.model.Bid;
import com.egov.tendering.bidding.dal.model.BidClarification;
import com.egov.tendering.bidding.dal.model.BidStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class BidEventPublisher {

    private final KafkaTemplate<String, BidEvent> kafkaTemplate;

    @Value("${app.kafka.topics.bid-events}")
    private String bidEventsTopic;

    public void publishBidCreatedEvent(Bid bid) {
        BidCreatedEvent event = BidCreatedEvent.builder()
                .eventId(System.currentTimeMillis())
                .eventType("BID_CREATED")
                .timestamp(LocalDateTime.now())
                .bidId(bid.getId())
                .tenderId(bid.getTenderId())
                .tendererId(bid.getTendererId())
                .totalPrice(bid.getTotalPrice())
                .itemCount(bid.getItems().size())
                .build();

        log.info("Publishing bid created event: {}", event);
        kafkaTemplate.send(bidEventsTopic, bid.getId().toString(), event);
    }


    public void publishBidSubmittedEvent(Bid bid) {
        BidSubmittedEvent event = BidSubmittedEvent.builder()
                .eventId(System.currentTimeMillis())
                .eventType("BID_SUBMITTED")
                .timestamp(LocalDateTime.now())
                .bidId(bid.getId())
                .tenderId(bid.getTenderId())
                .tendererId(bid.getTendererId())
                .totalPrice(bid.getTotalPrice())
                .submissionTime(bid.getSubmissionTime())
                .build();

        log.info("Publishing bid submitted event: {}", event);
        kafkaTemplate.send(bidEventsTopic, bid.getId().toString(), event);
    }

    public void publishBidStatusChangedEvent(Bid bid, BidStatus oldStatus) {
        BidStatusChangedEvent event = BidStatusChangedEvent.builder()
                .eventId(System.currentTimeMillis())
                .eventType("BID_STATUS_CHANGED")
                .timestamp(LocalDateTime.now())
                .bidId(bid.getId())
                .tenderId(bid.getTenderId())
                .tendererId(bid.getTendererId())
                .totalPrice(bid.getTotalPrice())
                .oldStatus(oldStatus)
                .newStatus(bid.getStatus())
                .build();

        log.info("Publishing bid status changed event: {}", event);
        kafkaTemplate.send(bidEventsTopic, bid.getId().toString(), event);
    }


    public void publishBidDeletedEvent(Bid bid) {
        BidDeletedEvent event = BidDeletedEvent.builder()
                .eventId(System.currentTimeMillis())
                .eventType("BID_DELETED")
                .timestamp(LocalDateTime.now())
                .bidId(bid.getId())
                .tenderId(bid.getTenderId())
                .tendererId(bid.getTendererId())
                .totalPrice(bid.getTotalPrice())
                .build();

        log.info("Publishing bid deleted event: {}", event);
        kafkaTemplate.send(bidEventsTopic, bid.getId().toString(), event);
    }


    public void publishClarificationRequestedEvent(Bid bid, BidClarification clarification) {
        BidClarificationRequestedEvent event = BidClarificationRequestedEvent.builder()
                .eventId(System.currentTimeMillis())
                .eventType("CLARIFICATION_REQUESTED")
                .timestamp(LocalDateTime.now())
                .bidId(bid.getId())
                .tenderId(bid.getTenderId())
                .tendererId(bid.getTendererId())
                .clarificationId(clarification.getId())
                .question(clarification.getQuestion())
                .requestedBy(clarification.getRequestedBy())
                .deadline(clarification.getDeadline())
                .build();

        log.info("Publishing clarification requested event: {}", event);
        kafkaTemplate.send(bidEventsTopic, bid.getId().toString(), event);
    }


    public void publishClarificationRespondedEvent(BidClarification clarification) {
        BidClarificationRespondedEvent event = BidClarificationRespondedEvent.builder()
                .eventId(System.currentTimeMillis())
                .eventType("CLARIFICATION_RESPONDED")
                .timestamp(LocalDateTime.now())
                .bidId(clarification.getBid().getId())
                .tenderId(clarification.getBid().getTenderId())
                .tendererId(clarification.getBid().getTendererId())
                .clarificationId(clarification.getId())
                .question(clarification.getQuestion())
                .response(clarification.getResponse())
                .respondedAt(clarification.getRespondedAt())
                .build();

        log.info("Publishing clarification responded event: {}", event);
        kafkaTemplate.send(bidEventsTopic, clarification.getBid().getId().toString(), event);
    }
}