package com.tms.tenderee;

public record TendereeRequest(
        Long toCostumerId,
        String toCustomerFullName,
        String message) {
}
