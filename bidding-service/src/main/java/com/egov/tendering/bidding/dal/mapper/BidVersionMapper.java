package com.egov.tendering.bidding.dal.mapper;

import com.egov.tendering.bidding.dal.dto.BidDTO;
import com.egov.tendering.bidding.dal.dto.BidVersionDTO;
import com.egov.tendering.bidding.dal.model.BidVersion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface BidVersionMapper {

    @Mapping(target = "versionData", source = "versionData", qualifiedByName = "jsonToBidDTO")
    BidVersionDTO toDto(BidVersion bidVersion);

    @Mapping(target = "versionData", source = "versionData", qualifiedByName = "bidDTOToJson")
    BidVersion toEntity(BidVersionDTO bidVersionDTO);

    @Named("jsonToBidDTO")
    default BidDTO jsonToBidDTO(String json) {
        try {
            return json != null ? new ObjectMapper().readValue(json, BidDTO.class) : null;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error parsing JSON bid data", e);
        }
    }

    @Named("bidDTOToJson")
    default String bidDTOToJson(BidDTO bidDTO) {
        try {
            return bidDTO != null ? new ObjectMapper().writeValueAsString(bidDTO) : null;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting bid data to JSON", e);
        }
    }
}