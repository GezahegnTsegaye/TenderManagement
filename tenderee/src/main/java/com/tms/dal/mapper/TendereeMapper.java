package com.tms.dal.mapper;

import com.tms.dal.dto.TendereeDTO;
import com.tms.dal.model.Tenderee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TendereeMapper {

  TendereeMapper INSTANCE = Mappers.getMapper(TendereeMapper.class);

  Tenderee toEntity(TendereeDTO tendereeDTO);
  TendereeDTO toDTO(Tenderee tenderee);

  List<TendereeDTO> toDTOList(List<Tenderee> tenderees);

}
