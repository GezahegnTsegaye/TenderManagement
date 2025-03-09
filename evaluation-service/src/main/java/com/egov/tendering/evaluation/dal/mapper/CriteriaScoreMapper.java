package com.egov.tendering.evaluation.dal.mapper;

import com.egov.tendering.evaluation.dal.dto.CriteriaScoreDTO;
import com.egov.tendering.evaluation.dal.model.CriteriaScore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CriteriaScoreMapper {

    @Mapping(target = "criteriaName", ignore = true)
    CriteriaScoreDTO toDto(CriteriaScore criteriaScore);

    List<CriteriaScoreDTO> toDtoList(List<CriteriaScore> criteriaScores);

    @Mapping(target = "evaluation", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CriteriaScore toEntity(CriteriaScoreDTO criteriaScoreDTO);
}