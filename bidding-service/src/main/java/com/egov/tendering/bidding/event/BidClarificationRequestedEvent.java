package com.egov.tendering.bidding.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BidClarificationRequestedEvent extends BidEvent {
    private Long clarificationId;
    private String question;
    private Long requestedBy;
    private LocalDateTime deadline;

}