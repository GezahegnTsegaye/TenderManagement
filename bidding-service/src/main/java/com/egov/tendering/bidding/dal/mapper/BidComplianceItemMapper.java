package com.egov.tendering.bidding.dal.mapper;


import com.egov.tendering.bidding.dal.dto.BidComplianceItemDTO;
import com.egov.tendering.bidding.dal.model.BidComplianceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidComplianceItemMapper {
    @Mapping(source = "bid.id", target = "bidId")
    BidComplianceItemDTO toDto(BidComplianceItem item);
    List<BidComplianceItemDTO> toDtoList(List<BidComplianceItem> items);
}