package com.egov.tendering.evaluation.dal.mapper;

import com.egov.tendering.evaluation.dal.dto.EvaluationDTO;
import com.egov.tendering.evaluation.dal.model.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CriteriaScoreMapper.class})
public interface EvaluationMapper {

    @Mapping(target = "bidderName", ignore = true)
    EvaluationDTO toDto(Evaluation evaluation);

    List<EvaluationDTO> toDtoList(List<Evaluation> evaluations);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Evaluation toEntity(EvaluationDTO evaluationDTO);
}