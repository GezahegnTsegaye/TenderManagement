package com.egov.tendering.tender.dal.mapper;


import com.egov.tendering.tender.dal.dto.TenderItemDTO;
import com.egov.tendering.tender.dal.model.TenderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenderItemMapper {

    // Remove the 'tender' mapping since it doesn't exist in the DTO
    @Mapping(target = "criteriaId", source = "criteria.id")
    TenderItemDTO toDto(TenderItem item);

    // For entity mapping, ignore fields that shouldn't be set directly
    @Mapping(target = "criteria", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TenderItem toEntity(TenderItemDTO itemDTO);

    List<TenderItemDTO> toDtoList(List<TenderItem> items);
}