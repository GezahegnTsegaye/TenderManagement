package com.egov.tendering.user.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserEvent {
    private Long eventId;
    private String eventType;
    private LocalDateTime timestamp;
    private Long userId;
    private String username;
}