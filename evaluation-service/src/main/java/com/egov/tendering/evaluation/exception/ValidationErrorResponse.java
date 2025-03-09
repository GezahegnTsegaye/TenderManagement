package com.egov.tendering.evaluation.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {
    private Map<String, String> fieldErrors;

    public ValidationErrorResponse(
            int status, String error, String message, Map<String, String> fieldErrors, LocalDateTime timestamp) {
        super(status, error, message, timestamp);
        this.fieldErrors = fieldErrors;
    }
}