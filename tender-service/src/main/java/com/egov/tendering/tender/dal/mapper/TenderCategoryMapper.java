package com.egov.tendering.tender.dal.mapper;


import com.egov.tendering.tender.dal.dto.TenderCriteriaDTO;
import com.egov.tendering.tender.dal.model.TenderCategory;
import org.mapstruct.Mapper;

import java.util.List;

;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenderCategoryMapper {

  TenderCriteriaDTO toDTO(TenderCategory tenderCategory);

  TenderCategory toEntity(TenderCriteriaDTO tenderCriteriaDTO);

  List<TenderCriteriaDTO> toDtoList(List<TenderCategory> tenderCategories);
}