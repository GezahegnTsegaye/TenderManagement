package com.egov.tendering.evaluation.event;

import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event payload for review update
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewUpdatedEvent {
    private Long reviewId;
    private Long tenderId;
    private Long committeeMemberId;
    private ReviewStatus oldStatus;
    private ReviewStatus newStatus;
    private LocalDateTime timestamp;
}