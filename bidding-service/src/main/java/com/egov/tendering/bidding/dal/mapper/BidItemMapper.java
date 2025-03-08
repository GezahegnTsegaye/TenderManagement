package com.egov.tendering.bidding.dal.mapper;


import com.egov.tendering.bidding.dal.dto.BidItemDTO;
import com.egov.tendering.bidding.dal.dto.BidItemRequest;
import com.egov.tendering.bidding.dal.model.BidItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidItemMapper {

  @Mapping(target = "criteriaName", ignore = true)
  BidItemDTO toDto(BidItem bidItem);

  @Mapping(target = "bid", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  BidItem toEntity(BidItemDTO bidItemDTO);

  List<BidItemDTO> toDtoList(List<BidItem> bidItems);

  /**
   * Map BidItem entity to BidItemRequest DTO.
   *
   * @param bidItem the BidItem entity
   * @return the BidItemRequest DTO
   */
  @Mapping(target = "criteriaId", source = "criteriaId")
  @Mapping(target = "value", source = "value")
  @Mapping(target = "description", source = "description")
  BidItemRequest toRequest(BidItem bidItem);
}
