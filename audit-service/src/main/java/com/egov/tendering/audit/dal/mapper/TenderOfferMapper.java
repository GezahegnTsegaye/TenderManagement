package com.egov.tendering.audit.dal.mapper;

import com.egov.tendering.audit.dal.dto.TenderOfferDTO;
import com.egov.tendering.audit.dal.model.TenderOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TenderOfferMapper {


  TenderOfferMapper INSTANCE = Mappers.getMapper(TenderOfferMapper.class);

  TenderOfferDTO toDTO(TenderOffer tenderOffer);
  TenderOffer toEntity(TenderOfferDTO tenderOfferDTO);
}
