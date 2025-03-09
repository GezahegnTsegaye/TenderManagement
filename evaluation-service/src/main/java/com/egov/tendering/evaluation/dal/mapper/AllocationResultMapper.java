package com.egov.tendering.evaluation.dal.mapper;

import com.egov.tendering.evaluation.dal.dto.AllocationResultDTO;
import com.egov.tendering.evaluation.dal.model.AllocationResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllocationResultMapper {

    @Mapping(target = "bidderName", ignore = true)
    @Mapping(target = "itemName", ignore = true)
    AllocationResultDTO toDto(AllocationResult result);

    List<AllocationResultDTO> toDtoList(List<AllocationResult> results);

    @Mapping(target = "createdAt", ignore = true)
    AllocationResult toEntity(AllocationResultDTO resultDTO);
}