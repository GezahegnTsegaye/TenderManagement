package com.egov.tendering.bidding.dal.mapper;


import com.egov.tendering.bidding.dal.dto.ComplianceRequirementDTO;
import com.egov.tendering.bidding.dal.model.ComplianceRequirement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComplianceRequirementMapper {
    ComplianceRequirementDTO toDto(ComplianceRequirement requirement);
    ComplianceRequirement toEntity(ComplianceRequirementDTO dto);
    List<ComplianceRequirementDTO> toDtoList(List<ComplianceRequirement> requirements);
}