package com.egov.tendering.bidding.exception;


/**
 * Exception thrown when a user attempts to perform an action they are not authorized to execute.
 */
public class AccessDeniedException extends RuntimeException {

    /**
     * Constructs a new AccessDeniedException with a custom message.
     *
     * @param message The detail message explaining why access was denied.
     */
    public AccessDeniedException(String message) {
        super(message);
    }

    /**
     * Constructs a new AccessDeniedException with a custom message and cause.
     *
     * @param message The detail message explaining why access was denied.
     * @param cause   The underlying cause of the exception (e.g., another exception).
     */
    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}