package com.egov.tendering.audit.services;

import com.egov.tendering.audit.dal.dto.EvaluationResultDTO;
import com.egov.tendering.audit.dal.dto.EvaluatorDTO;

public interface EvaluatorService {
  EvaluationResultDTO evaluateTenderOffer(Long tenderOfferId, Long evaluatorId);

  void createEvaluator(EvaluatorDTO evaluatorDTO);
}
