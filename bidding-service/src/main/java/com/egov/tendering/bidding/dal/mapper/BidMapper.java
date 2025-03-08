package com.egov.tendering.bidding.dal.mapper;


import com.egov.tendering.bidding.dal.dto.BidDTO;
import com.egov.tendering.bidding.dal.model.Bid;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BidItemMapper.class, BidDocumentMapper.class})
public interface BidMapper {

  @Mapping(target = "tendererName", ignore = true)
  BidDTO toDto(Bid bid);

  Bid toEntity(BidDTO bidDTO);
}