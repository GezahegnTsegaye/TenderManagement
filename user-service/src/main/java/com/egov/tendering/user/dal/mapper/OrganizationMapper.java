package com.egov.tendering.user.dal.mapper;

import com.egov.tendering.user.dal.dto.OrganizationDTO;
import com.egov.tendering.user.dal.model.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDTO toDto(Organization organization);
}