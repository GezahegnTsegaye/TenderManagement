package com.egov.tendering.bidding.dal.mapper;

import com.egov.tendering.bidding.dal.dto.BidSecurityDTO;
import com.egov.tendering.bidding.dal.model.BidSecurity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BidSecurityMapper {

    @Mapping(source = "bid.id", target = "bidId")
    BidSecurityDTO toDto(BidSecurity security);

    @Mapping(target = "bid", ignore = true)
    BidSecurity toEntity(BidSecurityDTO dto);
}