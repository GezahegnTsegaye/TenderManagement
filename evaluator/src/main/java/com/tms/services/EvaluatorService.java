package com.tms.services;

import com.tms.dal.dto.EvaluationResultDTO;
import com.tms.dal.dto.EvaluatorDTO;

public interface EvaluatorService {
  EvaluationResultDTO evaluateTenderOffer(Long tenderOfferId, Long evaluatorId);

  void createEvaluator(EvaluatorDTO evaluatorDTO);
}
