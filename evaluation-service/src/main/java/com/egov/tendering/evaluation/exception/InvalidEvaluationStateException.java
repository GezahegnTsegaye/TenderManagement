package com.egov.tendering.evaluation.exception;

/**
 * Exception thrown when an operation is attempted on an evaluation in an invalid state
 */
public class InvalidEvaluationStateException extends RuntimeException {

    public InvalidEvaluationStateException(String message) {
        super(message);
    }
}