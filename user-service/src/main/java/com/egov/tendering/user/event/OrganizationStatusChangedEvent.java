package com.egov.tendering.user.event;


import com.egov.tendering.user.dal.model.OrganizationStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class OrganizationStatusChangedEvent extends OrganizationEvent {
    private OrganizationStatus oldStatus;
    private OrganizationStatus newStatus;
}
