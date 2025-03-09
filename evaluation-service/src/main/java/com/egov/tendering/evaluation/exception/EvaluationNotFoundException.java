package com.egov.tendering.evaluation.exception;

import lombok.Getter;

/**
 * Exception thrown when an evaluation is not found
 */
@Getter
public class EvaluationNotFoundException extends RuntimeException {

    private final Long evaluationId;

    public EvaluationNotFoundException(Long evaluationId) {
        super("Evaluation not found with ID: " + evaluationId);
        this.evaluationId = evaluationId;
    }

    public EvaluationNotFoundException(String message) {
        super(message);
        this.evaluationId = null;
    }
}
