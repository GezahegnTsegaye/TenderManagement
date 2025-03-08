package com.egov.tendering.user.dal.dto;


import com.egov.tendering.user.dal.model.UserRole;
import com.egov.tendering.user.dal.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserRole role;
    private UserStatus status;
    private LocalDateTime createdAt;
    private Set<UserOrganizationDTO> organizations;
}