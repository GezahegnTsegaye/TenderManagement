package com.egov.tendering.evaluation.dal.dto;

import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for committee review data
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommitteeReviewDTO {

    private Long id;

    /**
     * ID of the tender being reviewed
     */
    private Long tenderId;

    /**
     * ID of the committee member who submitted the review
     */
    private Long committeeMemberId;

    /**
     * Name of the committee member (populated during enrichment)
     */
    private String committeeMemberName;

    /**
     * Status of the review (PENDING, REVIEWED, APPROVED, REJECTED)
     */
    private ReviewStatus status;

    /**
     * Optional comments from the committee member
     */
    private String comments;

    /**
     * When the review was created
     */
    private LocalDateTime createdAt;

    /**
     * When the review was last updated
     */
    private LocalDateTime updatedAt;
}