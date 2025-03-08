package com.egov.tendering.user.event;


import com.egov.tendering.user.dal.model.OrganizationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class OrganizationCreatedEvent extends OrganizationEvent {
    private String registrationNumber;
    private OrganizationType organizationType;
}
