package com.tms.dal.mapper;


import com.tms.dal.dto.BidHistoryDTO;
import com.tms.dal.models.bid.BidHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidHistoryMapper {

  BidHistoryMapper INSTANCE = Mappers.getMapper(BidHistoryMapper.class);

  BidHistoryDTO toDTO(BidHistory bidHistory);
  BidHistory toEntity(BidHistoryDTO bidHistoryDTO);
  List<BidHistory> toDTOList(List<BidHistory> bidHistories);
}
