package com.tms.dal.mapper;

import com.tms.dal.dto.BusinessCategoryDTO;
import com.tms.dal.models.business.BusinessCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessCategoryMapper {

  BusinessCategoryMapper  INSTANCE = Mappers.getMapper(BusinessCategoryMapper.class);

  BusinessCategoryDTO toDTO(BusinessCategory businessCategory);
  BusinessCategory toEntity(BusinessCategoryDTO businessCategoryDTO);
  List<BusinessCategoryDTO> toDTOList(List<BusinessCategory> businessCategories);

}
