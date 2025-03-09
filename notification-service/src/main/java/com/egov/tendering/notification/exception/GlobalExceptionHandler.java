package com.egov.tendering.notification.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotificationFailedException.class)
    public ResponseEntity<ErrorResponse> handleNotificationFailedException(NotificationFailedException ex) {
        ErrorResponse error = new ErrorResponse(
                "NOTIFICATION_FAILED",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotificationNotFoundException(NotificationNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                "NOTIFICATION_NOT_FOUND",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class ErrorResponse {
        private String code;
        private String message;
    }
}