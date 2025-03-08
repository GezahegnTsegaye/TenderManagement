package com.egov.tendering.bidding.exception;

import lombok.Getter;

/**
 * Exception thrown when a requested resource cannot be found in the system.
 */
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    /**
     * Constructs a new ResourceNotFoundException with a detailed message.
     *
     * @param resourceName The name of the resource that was not found (e.g., "Bid", "BidSecurity").
     * @param fieldName    The field used to search for the resource (e.g., "id").
     * @param fieldValue   The value of the field that was searched (e.g., 123L).
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    /**
     * Constructs a new ResourceNotFoundException with a custom message.
     *
     * @param message The custom error message.
     */
    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceName = null;
        this.fieldName = null;
        this.fieldValue = null;
    }
}