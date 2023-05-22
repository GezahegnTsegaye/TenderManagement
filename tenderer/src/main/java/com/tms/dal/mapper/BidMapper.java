package com.tms.dal.mapper;


import com.tms.dal.dto.BidDTO;
import com.tms.dal.models.bid.Bid;
import com.tms.dal.models.bid.BidItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidMapper {

  BidMapper INSTANCE = Mappers.getMapper(BidMapper.class);

  BidDTO toDTO(Bid bid);
  Bid toEntity(BidDTO bidDTO);

  List<BidDTO> toDTOList(List<Bid> bids);

  void updateEntityFromDTO(BidDTO bidDTO, @MappingTarget Bid bid);
}
