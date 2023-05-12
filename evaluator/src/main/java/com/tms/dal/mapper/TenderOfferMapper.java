package com.tms.dal.mapper;

import com.tms.dal.dto.TenderOfferDTO;
import com.tms.dal.model.TenderOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TenderOfferMapper {


  TenderOfferMapper INSTANCE = Mappers.getMapper(TenderOfferMapper.class);

  TenderOfferDTO toDTO(TenderOffer tenderOffer);
  TenderOffer toEntity(TenderOfferDTO tenderOfferDTO);
}
