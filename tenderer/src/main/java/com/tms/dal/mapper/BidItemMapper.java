package com.tms.dal.mapper;


import com.tms.dal.dto.BidItemDTO;
import com.tms.dal.models.bid.BidItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BidItemMapper {

  BidItemMapper INSTANCE = Mappers.getMapper(BidItemMapper.class);

  BidItem toEntity(BidItemDTO bidItemDTO);

  BidItemDTO toDTO(BidItem bidItem);

  void updateEntityFromDTO(BidItemDTO bidItemDTO, @MappingTarget BidItem bidItem);

}
