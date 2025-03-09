package com.egov.tendering.evaluation.dal.mapper;

import com.egov.tendering.evaluation.dal.dto.TenderRankingDTO;
import com.egov.tendering.evaluation.dal.model.TenderRanking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TenderRankingMapper {

    @Mapping(target = "bidderName", ignore = true)
    TenderRankingDTO toDto(TenderRanking ranking);

    List<TenderRankingDTO> toDtoList(List<TenderRanking> rankings);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TenderRanking toEntity(TenderRankingDTO rankingDTO);
}