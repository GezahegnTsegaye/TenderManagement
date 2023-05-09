package com.tms.evaluator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@NoArgsConstructor@AllArgsConstructor@Getter
public class EvaluatorRequest {

  private Long toEvaluatorId;
  private String toEvaluatorFullName;
  private String message;
}
