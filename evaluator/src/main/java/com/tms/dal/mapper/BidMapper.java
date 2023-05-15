package com.tms.dal.mapper;

import com.tms.dal.dto.BidDTO;
import com.tms.dal.model.Bid;
import org.mapstruct.factory.Mappers;

public interface BidMapper {

  BidMapper INSTANCE = Mappers.getMapper(BidMapper.class);

  BidDTO toDTO(com.tms.dal.model.Bid bid);

  Bid toBid(BidDTO bidDTO);


}
