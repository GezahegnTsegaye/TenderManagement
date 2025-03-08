package com.egov.tendering.user.event;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class UserOrganizationChangedEvent extends UserEvent {
    private Long organizationId;
    private String organizationName;
    private String action;  // "ADDED" or "REMOVED"
    private String role;
}
