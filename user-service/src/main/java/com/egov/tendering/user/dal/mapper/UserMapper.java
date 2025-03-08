package com.egov.tendering.user.dal.mapper;

import com.egov.tendering.user.dal.dto.UserDTO;
import com.egov.tendering.user.dal.dto.UserOrganizationDTO;
import com.egov.tendering.user.dal.model.User;
import com.egov.tendering.user.dal.model.UserOrganization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    @Mapping(source = "organization.id", target = "organizationId")
    @Mapping(source = "organization.name", target = "organizationName")
    UserOrganizationDTO toDto(UserOrganization userOrganization);
}