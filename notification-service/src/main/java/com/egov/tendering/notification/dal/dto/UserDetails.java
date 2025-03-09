package com.egov.tendering.notification.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {
    private String userId;
    private String email;
    private String phoneNumber;
    private String fullName;
}