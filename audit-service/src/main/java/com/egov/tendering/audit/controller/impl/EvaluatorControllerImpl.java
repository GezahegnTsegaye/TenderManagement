package com.egov.tendering.audit.controller.impl;

import com.egov.tendering.audit.controller.EvaluatorController;
import com.egov.tendering.audit.services.EvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/evaluators")
public class EvaluatorControllerImpl implements EvaluatorController {

  private final EvaluatorService evaluatorService;


}
