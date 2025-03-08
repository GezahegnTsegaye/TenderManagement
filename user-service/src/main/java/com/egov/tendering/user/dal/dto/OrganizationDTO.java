package com.egov.tendering.user.dal.dto;


import com.egov.tendering.user.dal.model.OrganizationStatus;
import com.egov.tendering.user.dal.model.OrganizationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
    private Long id;
    private String name;
    private String registrationNumber;
    private String address;
    private String contactPerson;
    private String phone;
    private String email;
    private OrganizationType organizationType;
    private OrganizationStatus status;
    private LocalDateTime createdAt;
}
