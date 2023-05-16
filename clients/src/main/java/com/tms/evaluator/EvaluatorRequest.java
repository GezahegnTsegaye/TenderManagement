package com.tms.evaluator;


public record EvaluatorRequest(
        Long toEvaluatorId,
        String toEvaluatorFullName,
        String message) {
}
