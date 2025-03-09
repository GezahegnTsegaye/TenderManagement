package com.egov.tendering.audit.dal.mapper;

import com.egov.tendering.audit.dal.dto.BidDTO;
import com.egov.tendering.audit.dal.model.Bid;
import org.mapstruct.factory.Mappers;

public interface BidMapper {

  BidMapper INSTANCE = Mappers.getMapper(BidMapper.class);

  BidDTO toDTO(Bid bid);

  Bid toBid(BidDTO bidDTO);


}
