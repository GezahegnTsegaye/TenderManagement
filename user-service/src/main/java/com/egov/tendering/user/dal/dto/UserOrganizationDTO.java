package com.egov.tendering.user.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOrganizationDTO {
    private Long organizationId;
    private String organizationName;
    private String role;
}