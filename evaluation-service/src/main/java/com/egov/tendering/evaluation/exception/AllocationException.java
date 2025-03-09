package com.egov.tendering.evaluation.exception;

public class AllocationException  extends RuntimeException {

    private final Long allocationId;

    public AllocationException(Long allocationId) {
        super("Allocation not found with ID: " + allocationId);
        this.allocationId = allocationId;
    }

    public AllocationException(String message) {
        super(message);
        this.allocationId = null;
    }
}