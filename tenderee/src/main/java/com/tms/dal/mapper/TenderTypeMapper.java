package com.tms.dal.mapper;


import com.tms.dal.dto.TenderTypeDTO;
import com.tms.dal.model.TenderType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TenderTypeMapper {

  TenderTypeMapper INSTANCE = Mappers.getMapper(TenderTypeMapper.class);
  TenderType toEntity(TenderTypeDTO tenderTypeDTO);


}
