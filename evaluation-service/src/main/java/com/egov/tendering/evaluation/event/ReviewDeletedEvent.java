package com.egov.tendering.evaluation.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event payload for review deletion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDeletedEvent {
    private Long reviewId;
    private Long tenderId;
    private Long committeeMemberId;
    private LocalDateTime timestamp;
}