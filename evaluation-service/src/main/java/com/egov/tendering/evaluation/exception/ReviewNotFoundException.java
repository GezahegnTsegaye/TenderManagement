package com.egov.tendering.evaluation.exception;

import lombok.Getter;

/**
 * Exception thrown when a review is not found
 */
@Getter
public class ReviewNotFoundException extends RuntimeException {

    private final Long reviewId;

    public ReviewNotFoundException(Long reviewId) {
        super("Review not found with ID: " + reviewId);
        this.reviewId = reviewId;
    }

    public ReviewNotFoundException(String message) {
        super(message);
        this.reviewId = null;
    }
}