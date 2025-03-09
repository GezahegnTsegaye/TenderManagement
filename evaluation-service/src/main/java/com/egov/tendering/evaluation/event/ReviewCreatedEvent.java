package com.egov.tendering.evaluation.event;

import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event payload for review creation
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreatedEvent {
    private Long reviewId;
    private Long tenderId;
    private Long committeeMemberId;
    private ReviewStatus status;
    private LocalDateTime timestamp;
}