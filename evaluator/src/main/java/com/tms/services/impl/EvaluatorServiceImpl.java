package com.tms.services.impl;


import com.tms.dal.dto.EvaluatorDTO;
import com.tms.dal.mapper.EvaluatorMapper;
import com.tms.dal.repository.EvaluatorRepository;
import com.tms.services.EvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EvaluatorServiceImpl implements EvaluatorService {

  private final EvaluatorRepository evaluatorRepository;
  private final EvaluatorMapper evaluatorMapper;


  @Override
  public void createEvaluator(EvaluatorDTO evaluatorDTO) {
    evaluatorRepository.save(evaluatorMapper.toEntity(evaluatorDTO));
  }
}
