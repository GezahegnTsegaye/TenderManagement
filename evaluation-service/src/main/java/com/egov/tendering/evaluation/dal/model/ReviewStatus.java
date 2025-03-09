package com.egov.tendering.evaluation.dal.model;


/**
 * Enum representing the possible statuses of a committee review
 */
public enum ReviewStatus {
    /**
     * Review is pending, not yet submitted
     */
    PENDING,

    /**
     * Review has been submitted but not yet approved or rejected
     */
    REVIEWED,

    /**
     * Review has been approved by the committee member
     */
    APPROVED,

    /**
     * Review has been rejected by the committee member
     */
    REJECTED
}