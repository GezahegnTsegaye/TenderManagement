package com.egov.tendering.audit.dal.mapper;

import com.egov.tendering.audit.dal.dto.EvaluatorDTO;
import com.egov.tendering.audit.dal.model.Evaluator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvaluatorMapper {
  EvaluatorMapper INSTANCE = Mappers.getMapper(EvaluatorMapper.class);

  EvaluatorDTO toDTO(Evaluator evaluator);
  Evaluator toEntity(EvaluatorDTO evaluatorDTO);
  List<EvaluatorDTO> toDtoList(List<Evaluator> evaluators);

}
