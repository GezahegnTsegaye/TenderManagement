package com.egov.tendering.notification.dal.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    // Tender-related notifications
    TENDER_CREATED(NotificationChannel.EMAIL),
    TENDER_UPDATED(NotificationChannel.EMAIL),
    TENDER_PUBLISHED(NotificationChannel.EMAIL),
    TENDER_CLOSED(NotificationChannel.EMAIL),
    TENDER_CANCELLED(NotificationChannel.EMAIL),

    // Bid-related notifications
    BID_SUBMITTED(NotificationChannel.EMAIL),
    BID_UPDATED(NotificationChannel.EMAIL),
    BID_WITHDRAWN(NotificationChannel.EMAIL),
    BID_EVALUATION_COMPLETED(NotificationChannel.EMAIL),

    // Contract-related notifications
    CONTRACT_AWARDED(NotificationChannel.EMAIL),
    CONTRACT_SIGNED(NotificationChannel.EMAIL),
    CONTRACT_CANCELLED(NotificationChannel.EMAIL),

    // User-related notifications
    USER_REGISTERED(NotificationChannel.EMAIL),
    PASSWORD_RESET(NotificationChannel.EMAIL),

    // Deadline reminders
    BID_DEADLINE_REMINDER(NotificationChannel.EMAIL),
    DOCUMENT_SUBMISSION_REMINDER(NotificationChannel.EMAIL),

    // System notifications
    SYSTEM_MAINTENANCE(NotificationChannel.DASHBOARD);

    private final NotificationChannel channel;
}