package com.egov.tendering.notification.exception;

public class NotificationFailedException extends RuntimeException {

    public NotificationFailedException(String message) {
        super(message);
    }
    public NotificationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
