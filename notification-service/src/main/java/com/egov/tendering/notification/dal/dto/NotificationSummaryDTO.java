package com.egov.tendering.notification.dal.dto;

import com.egov.tendering.notification.dal.model.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSummaryDTO {
    private Long id;
    private NotificationType type;
    private String subject;
    private String entityId;
    private LocalDateTime createdAt;
    private boolean read;
}