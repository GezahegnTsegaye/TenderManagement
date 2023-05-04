package com.tms.dal.mapper;

import com.tms.dal.dto.EvaluatorDTO;
import com.tms.dal.model.Evaluator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EvaluatorMapper {
  EvaluatorMapper INSTANCE = Mappers.getMapper(EvaluatorMapper.class);

  EvaluatorDTO toDTO(Evaluator evaluator);
  Evaluator toEntity(EvaluatorDTO evaluatorDTO);

}
