package com.egov.tendering.bidding.dal.mapper;

import com.egov.tendering.bidding.dal.dto.BidClarificationDTO;
import com.egov.tendering.bidding.dal.model.BidClarification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidClarificationMapper {
    @Mapping(source = "bid.id", target = "bidId")
    BidClarificationDTO toDto(BidClarification clarification);
    List<BidClarificationDTO> toDtoList(List<BidClarification> clarifications);
}