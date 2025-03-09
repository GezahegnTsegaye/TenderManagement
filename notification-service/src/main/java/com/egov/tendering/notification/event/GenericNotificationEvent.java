package com.egov.tendering.notification.event;

import com.egov.tendering.notification.dal.model.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Event class for general notifications sent through Kafka
 * This is used for compatibility with services that don't need the specific event types
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericNotificationEvent {
    private String id;
    private NotificationType type;
    private String entityId;
    private String subject;
    private String message;
    private List<String> recipients;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime sentAt;
}