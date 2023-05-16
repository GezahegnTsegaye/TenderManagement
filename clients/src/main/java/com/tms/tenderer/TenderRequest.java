package com.tms.tenderer;

public record TenderRequest(
        Long toTinderId,
        String toTenderName,
        String message ) {
}
