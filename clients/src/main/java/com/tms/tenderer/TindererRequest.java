package com.tms.tenderer;

public record TindererRequest(
        Long toTindererId,
        String toTinderer,
        String message
) {
}
