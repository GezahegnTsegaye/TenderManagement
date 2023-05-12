package com.tms.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter@NoArgsConstructor@AllArgsConstructor
public class EvaluationResultDTO {

  private Long id;

  private Long tenderOfferId;

  private Long evaluatorId;

  private Double overallScore;

  private Map<String, Double> attributeScores;

  // Constructors, getters, setters
}

