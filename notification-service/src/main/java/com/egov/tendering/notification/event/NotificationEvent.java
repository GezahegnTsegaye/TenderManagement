package com.egov.tendering.notification.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "eventType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailSentEvent.class, name = "EMAIL_SENT"),
        @JsonSubTypes.Type(value = SmsSentEvent.class, name = "SMS_SENT"),
        @JsonSubTypes.Type(value = PushSentEvent.class, name = "PUSH_SENT"),
        @JsonSubTypes.Type(value = NotificationFailedEvent.class, name = "NOTIFICATION_FAILED"),
        @JsonSubTypes.Type(value = NotificationRetryEvent.class, name = "NOTIFICATION_RETRY")
})
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class NotificationEvent {
    private Long eventId;
    private NotificationEventType eventType;
    private LocalDateTime timestamp;
    private Long notificationId;
}