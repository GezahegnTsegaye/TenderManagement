package com.egov.tendering.bidding.dal.mapper;


import com.egov.tendering.bidding.dal.dto.BidDocumentDTO;
import com.egov.tendering.bidding.dal.model.BidDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidDocumentMapper {

    BidDocumentDTO toDto(BidDocument bidDocument);

    @Mapping(target = "bid", ignore = true)
    @Mapping(target = "uploadedBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    BidDocument toEntity(BidDocumentDTO bidDocumentDTO);

    List<BidDocumentDTO> toDtoList(List<BidDocument> bidDocuments);
}