package com.tms.dal.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TenderTypeMapper {

  TenderTypeMapper INSTANCE = Mappers.getMapper(TenderTypeMapper.class);


}
