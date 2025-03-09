package com.egov.tendering.notification.dal.dto;

import com.egov.tendering.notification.dal.model.NotificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    @NotNull
    private NotificationType type;

    @NotBlank
    private String entityId;

    @NotBlank
    private String subject;

    @NotBlank
    private String message;

    @NotEmpty
    private List<String> recipients;
}