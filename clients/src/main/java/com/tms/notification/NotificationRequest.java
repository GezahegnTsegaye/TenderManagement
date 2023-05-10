package com.tms.notification;


public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}