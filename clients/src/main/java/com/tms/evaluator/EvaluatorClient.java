package com.tms.evaluator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "evalutor",
url="${clients.evaluator.url}")
public interface EvaluatorClient {
//  @PostMapping("api/evaluators")
  public void sendEvaluator(EvaluatorRequest evaluatorRequest);
}
