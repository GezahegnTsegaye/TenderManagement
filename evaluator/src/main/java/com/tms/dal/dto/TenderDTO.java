package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class TenderDTO {

  private Long id;

  private String description;

  private LocalDate deadline;

  private List<EvaluationCriterionDTO> evaluationCriteria;

  // Constructors, getters, setters
}
