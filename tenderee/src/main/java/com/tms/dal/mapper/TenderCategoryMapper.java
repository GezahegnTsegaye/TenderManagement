package com.tms.dal.mapper;


import com.tms.dal.dto.TenderCategoryDTO;
import com.tms.dal.model.TenderCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenderCategoryMapper {

  TenderCategoryMapper INSTANCE = Mappers.getMapper(TenderCategoryMapper.class);

  TenderCategoryDTO toDTO(TenderCategory tenderCategory);
  TenderCategory toEntity(TenderCategoryDTO tenderCategoryDTO);

  List<TenderCategoryDTO> toDtoList(List<TenderCategory> tenderCategories);
}
