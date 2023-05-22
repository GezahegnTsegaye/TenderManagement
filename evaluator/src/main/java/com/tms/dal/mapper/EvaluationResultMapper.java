package com.tms.dal.mapper;


import com.tms.dal.dto.EvaluationResultDTO;
import com.tms.dal.model.EvaluationResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvaluationResultMapper {


  EvaluationResultMapper INSTANCE = Mappers.getMapper(EvaluationResultMapper.class);

  EvaluationResult toEntity(EvaluationResultDTO evaluationResultDTO);
  EvaluationResultDTO toDto(EvaluationResult evaluationResult);

  EvaluationResultDTO toDtoList(List<EvaluationResult> evaluationResults);


}
