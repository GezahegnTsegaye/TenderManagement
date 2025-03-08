package com.egov.tendering.tender.dal.mapper;

import com.egov.tendering.tender.dal.dto.PricingItemDTO;
import com.egov.tendering.tender.dal.model.PricingItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PricingItemMapper {

    PricingItemDTO toDto(PricingItem pricingItem);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PricingItem toEntity(PricingItemDTO pricingItemDTO);

    List<PricingItemDTO> toDtoList(List<PricingItem> pricingItems);
}