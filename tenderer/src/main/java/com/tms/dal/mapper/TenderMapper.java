package com.tms.dal.mapper;

import com.tms.dal.dto.TenderDTO;
import com.tms.dal.models.Tender;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenderMapper {

  TenderMapper INSTANCE = Mappers.getMapper(TenderMapper.class);

  TenderDTO toDTO(Tender tender);
  Tender toEntity(TenderDTO tenderDTO);
  List<TenderDTO> toDTOList(List<Tender> tenders);


}
