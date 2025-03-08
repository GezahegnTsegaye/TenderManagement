package com.egov.tendering.tender.dal.mapper;

import com.egov.tendering.tender.dal.dto.TenderCriteriaDTO;
import com.egov.tendering.tender.dal.dto.TenderDTO;
import com.egov.tendering.tender.dal.dto.TenderItemDTO;
import com.egov.tendering.tender.dal.model.Tender;
import com.egov.tendering.tender.dal.model.TenderCriteria;
import com.egov.tendering.tender.dal.model.TenderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring", uses = {TenderCriteriaMapper.class, TenderItemMapper.class})
public interface TenderMapper {

  TenderDTO toDto(Tender tender);

  Tender toEntity(TenderDTO tenderDTO);

  List<TenderDTO> toDtoList(List<Tender> tenders);
}