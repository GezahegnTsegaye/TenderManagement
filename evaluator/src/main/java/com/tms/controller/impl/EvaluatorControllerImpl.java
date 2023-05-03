package com.tms.controller.impl;

import com.tms.controller.EvaluatorController;
import com.tms.services.EvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/evaluators")
public class EvaluatorControllerImpl implements EvaluatorController {

  private final EvaluatorService evaluatorService;


}
