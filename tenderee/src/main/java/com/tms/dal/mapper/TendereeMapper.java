package com.tms.dal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TendereeMapper {

  TendereeMapper INSTANCE = Mappers.getMapper(TendereeMapper.class);

}
