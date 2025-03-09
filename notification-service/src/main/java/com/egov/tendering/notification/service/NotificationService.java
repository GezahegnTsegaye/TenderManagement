package com.egov.tendering.notification.service;

import com.egov.tendering.notification.config.KafkaTopics;
import com.egov.tendering.notification.dal.dto.NotificationRequest;
import com.egov.tendering.notification.dal.dto.NotificationResponse;
import com.egov.tendering.notification.dal.model.Notification;
import com.egov.tendering.notification.dal.model.NotificationType;
import com.egov.tendering.notification.dal.repository.NotificationRepository;
import com.egov.tendering.notification.event.GenericNotificationEvent;
import com.egov.tendering.notification.event.NotificationEvent;
import com.egov.tendering.notification.event.NotificationEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;
    private final SmsService smsService;
    private final PushNotificationService pushNotificationService;
    private final KafkaTemplate<String, GenericNotificationEvent> kafkaTemplate;
    private final NotificationEventPublisher eventPublisher;

    @KafkaListener(topics = "${kafka.topics.tender-created}")
    public void handleTenderCreated(GenericNotificationEvent event) {
        log.info("Received tender created event: {}", event);
        sendNotification(
                NotificationType.TENDER_CREATED,
                String.valueOf(event.getEntityId()),
                "New Tender Created",
                "A new tender has been created: " + event.getEntityId(),
                event.getRecipients()
        );
    }

    @KafkaListener(topics = "${kafka.topics.tender-updated}")
    public void handleTenderUpdated(GenericNotificationEvent event) {
        log.info("Received tender updated event: {}", event);
        sendNotification(
                NotificationType.TENDER_UPDATED,
                event.getEntityId(),
                "Tender Updated",
                "Tender has been updated: " + event.getEntityId(),
                event.getRecipients()
        );
    }

    @KafkaListener(topics = "${kafka.topics.bid-submitted}")
    public void handleBidSubmitted(GenericNotificationEvent event) {
        log.info("Received bid submitted event: {}", event);

        // Convert single recipient to list if necessary
        List<String> recipients;
        if (event.getRecipients() != null) {
            recipients = Collections.singletonList(String.valueOf(event.getRecipients()));
        } else {
            recipients = new ArrayList<>();
        }

        sendNotification(
                NotificationType.BID_SUBMITTED,
                event.getEntityId(),
                "New Bid Submitted",
                "A new bid has been submitted for tender: " + event.getEntityId(),
                recipients
        );
    }

    @KafkaListener(topics = "${kafka.topics.bid-evaluation-completed}")
    public void handleBidEvaluationCompleted(GenericNotificationEvent event) {
        log.info("Received bid evaluation completed event: {}", event);

        // Convert single recipient to list if necessary
        List<String> recipients;
        if (event.getRecipients() != null) {
            recipients = Collections.singletonList(String.valueOf(event.getRecipients()));
        } else {
            recipients = new ArrayList<>();
        }

        sendNotification(
                NotificationType.BID_EVALUATION_COMPLETED,
                event.getEntityId(),
                "Bid Evaluation Completed",
                "Bid evaluation has been completed for tender: " + event.getEntityId(),
                recipients
        );
    }

    @KafkaListener(topics = "${kafka.topics.contract-awarded}")
    public void handleContractAwarded(GenericNotificationEvent event) {
        log.info("Received contract awarded event: {}", event);

        // Convert single recipient to list if necessary
        List<String> recipients;
        if (event.getRecipients() != null) {
            recipients = Collections.singletonList(String.valueOf(event.getRecipients()));
        } else {
            recipients = new ArrayList<>();
        }

        sendNotification(
                NotificationType.CONTRACT_AWARDED,
                event.getEntityId(),
                "Contract Awarded",
                "A contract has been awarded for tender: " + event.getEntityId(),
                recipients
        );
    }

    @Transactional
    public NotificationResponse sendNotification(NotificationRequest request) {
        log.info("Sending notification: {}", request);
        Notification notification = createNotification(
                request.getType(),
                request.getEntityId(),
                request.getSubject(),
                request.getMessage(),
                request.getRecipients()
        );

        deliverNotification(notification);

        GenericNotificationEvent event = createGenericNotificationEvent(notification);
        kafkaTemplate.send(KafkaTopics.NOTIFICATION_SENT, event);

        return new NotificationResponse(
                notification.getId(),
                notification.getStatus(),
                "Notification sent successfully"
        );
    }

    @Transactional
    public NotificationResponse scheduleNotification(NotificationRequest request, LocalDateTime scheduledTime) {
        log.info("Scheduling notification for {}: {}", scheduledTime, request);

        Notification notification = createNotification(
                request.getType(),
                request.getEntityId(),
                request.getSubject(),
                request.getMessage(),
                request.getRecipients()
        );

        // Set scheduled time
        notification.setStatus("SCHEDULED");
        notification.setScheduledAt(scheduledTime);

        // Save to repository
        notification = notificationRepository.save(notification);

        log.info("Notification scheduled with ID: {}", notification.getId());

        return new NotificationResponse(
                notification.getId(),
                notification.getStatus(),
                "Notification scheduled successfully"
        );
    }

    @Transactional(readOnly = true)
    public List<Notification> getNotificationsForUser(String userId) {
        log.info("Fetching notifications for user: {}", userId);
        return notificationRepository.findByRecipientOrderByCreatedAtDesc(userId);
    }

    @Transactional(readOnly = true)
    public List<Notification> getUnreadNotificationsForUser(String userId) {
        log.info("Fetching unread notifications for user: {}", userId);
        return notificationRepository.findUnreadByRecipient(userId);
    }

    @Transactional(readOnly = true)
    public long countUnreadNotifications(String userId) {
        log.info("Counting unread notifications for user: {}", userId);
        return notificationRepository.countUnreadByRecipient(userId);
    }

    @Transactional(readOnly = true)
    public java.util.Optional<Notification> getNotification(String notificationId) {
        log.info("Fetching notification details: {}", notificationId);
        return notificationRepository.findById(notificationId);
    }

    @Transactional
    public void markAsRead(String notificationId) {
        log.info("Marking notification as read: {}", notificationId);
        notificationRepository.findById(notificationId).ifPresent(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
    }

    private void sendNotification(NotificationType type, String entityId, String subject, String message, List<String> recipients) {
        Notification notification = createNotification(type, entityId, subject, message, recipients);
        deliverNotification(notification);
    }

    private Notification createNotification(NotificationType type, String entityId, String subject, String message, List<String> recipients) {
        Notification notification = new Notification();
        notification.setType(type);
        notification.setEntityId(entityId);
        notification.setSubject(subject);
        notification.setMessage(message);
        notification.setRecipients(recipients);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);
        notification.setStatus("PENDING");
        notification.setRetryCount(0);

        return notificationRepository.save(notification);
    }

    private void deliverNotification(Notification notification) {
        try {
            notification.setSentAt(LocalDateTime.now());

            switch (notification.getType().getChannel()) {
                case EMAIL:
                    emailService.sendEmail(notification);
                    break;
                case SMS:
                    smsService.sendSms(notification);
                    break;
                case PUSH:
                    pushNotificationService.sendPushNotification(notification);
                    break;
                case DASHBOARD:
                    // Just save to repository - no delivery needed
                    notification.setStatus("DELIVERED");
                    notification.setDeliveredAt(LocalDateTime.now());
                    break;
                default:
                    log.warn("Unknown channel for notification type: {}", notification.getType());
                    notification.setStatus("FAILED");
                    notification.setErrorMessage("Unknown notification channel");
                    break;
            }

            // If notification was delivered successfully
            if ("DELIVERED".equals(notification.getStatus())) {
                // Publish appropriate event based on channel
                if (notification.getType().getChannel() == com.egov.tendering.notification.dal.model.NotificationChannel.EMAIL) {
                    eventPublisher.publishEmailSentEvent(notification);
                } else if (notification.getType().getChannel() == com.egov.tendering.notification.dal.model.NotificationChannel.SMS) {
                    eventPublisher.publishSmsSentEvent(notification);
                } else if (notification.getType().getChannel() == com.egov.tendering.notification.dal.model.NotificationChannel.PUSH) {
                    eventPublisher.publishPushSentEvent(notification);
                }
            }

        } catch (Exception e) {
            log.error("Failed to deliver notification: {}", notification.getId(), e);
            notification.setStatus("FAILED");
            notification.setErrorMessage(e.getMessage());

            // Increment retry count if this should be retried
            if (notification.getRetryCount() < 3) { // Max 3 retries
                notification.setRetryCount(notification.getRetryCount() + 1);
                notification.setStatus("PENDING_RETRY");
                notification.setLastRetryAt(LocalDateTime.now());

                // Publish retry event
                eventPublisher.publishNotificationRetryEvent(notification);
            } else {
                // Publish failure event
                eventPublisher.publishNotificationFailedEvent(notification, e.getMessage());
            }
        }

        notificationRepository.save(notification);
    }

    /**
     * Create a generic notification event for Kafka
     * This is different from the specific event types used by NotificationEventPublisher
     *
     * @param notification The notification entity
     * @return A generic notification event
     */
    private GenericNotificationEvent createGenericNotificationEvent(Notification notification) {
        return GenericNotificationEvent.builder()
                .id(String.valueOf(notification.getId()))
                .type(notification.getType())
                .entityId(notification.getEntityId())
                .subject(notification.getSubject())
                .message(notification.getMessage())
                .recipients(notification.getRecipients())
                .status(notification.getStatus())
                .createdAt(notification.getCreatedAt())
                .deliveredAt(notification.getDeliveredAt())
                .sentAt(notification.getSentAt())
                .build();
    }
}