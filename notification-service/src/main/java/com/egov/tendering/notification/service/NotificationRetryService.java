package com.egov.tendering.notification.service;


import com.egov.tendering.notification.dal.model.Notification;
import com.egov.tendering.notification.dal.model.NotificationChannel;
import com.egov.tendering.notification.dal.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationRetryService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;
    private final SmsService smsService;
    private final PushNotificationService pushNotificationService;

    /**
     * Retry interval in minutes between retry attempts
     */
    private static final int RETRY_DELAY_MINUTES = 5;

    /**
     * Scheduled job that runs every minute to check for notifications that need to be retried
     */
    @Scheduled(fixedRate = 60000) // Run every minute
    @Transactional
    public void retryFailedNotifications() {
        log.debug("Checking for notifications to retry...");

        // Find notifications scheduled for retry
        List<Notification> notificationsToRetry = notificationRepository
                .findByStatusAndLastRetryAtBefore(
                        "PENDING_RETRY",
                        LocalDateTime.now().minus(RETRY_DELAY_MINUTES, ChronoUnit.MINUTES)
                );

        if (notificationsToRetry.isEmpty()) {
            log.debug("No notifications to retry at this time");
            return;
        }

        log.info("Found {} notifications to retry", notificationsToRetry.size());

        for (Notification notification : notificationsToRetry) {
            retryNotification(notification);
        }
    }

    private void retryNotification(Notification notification) {
        log.info("Retrying notification: {} (attempt {}/{})",
                notification.getId(),
                notification.getRetryCount(),
                getMaxRetryAttempts());

        try {
            NotificationChannel channel = notification.getType().getChannel();

            switch (channel) {
                case EMAIL:
                    emailService.sendEmail(notification);
                    break;
                case SMS:
                    smsService.sendSms(notification);
                    break;
                case PUSH:
                    pushNotificationService.sendPushNotification(notification);
                    break;
                default:
                    log.warn("Unsupported channel for retry: {}", channel);
                    break;
            }
        } catch (Exception e) {
            log.error("Error during retry of notification {}: {}",
                    notification.getId(), e.getMessage());
        }
    }

    private int getMaxRetryAttempts() {
        // This could be moved to a configuration property
        return 3;
    }
}