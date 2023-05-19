package com.tms.dal.mapper;

import com.tms.dal.dto.BusinessRegistrationDTO;
import com.tms.dal.models.business.BusinessRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusinessRegistrationMapper {

  BusinessRegistrationMapper INSTANCE = Mappers.getMapper(BusinessRegistrationMapper.class);

  @Mapping(source = "businessCategory.categoryId", target = "businessCategory.categoryId")
  @Mapping(source = "businessCategory.categoryName", target = "businessCategory.categoryName")
  BusinessRegistrationDTO toDTO(BusinessRegistration businessRegistration);

  @Mapping(source = "businessCategory.categoryId", target = "businessCategory.categoryId")
  @Mapping(source = "businessCategory.categoryName", target = "businessCategory.categoryName")
  BusinessRegistration toEntity(BusinessRegistrationDTO businessRegistrationDTO);


  List<BusinessRegistrationDTO> toDtoList(List<BusinessRegistration> businessRegistrations);

  // Other mapping methods...
}
