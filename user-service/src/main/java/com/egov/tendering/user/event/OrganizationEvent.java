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
public abstract class OrganizationEvent {
    private Long eventId;
    private String eventType;
    private LocalDateTime timestamp;
    private Long organizationId;
    private String organizationName;
}
