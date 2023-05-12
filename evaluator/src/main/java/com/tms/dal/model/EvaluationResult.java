package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evaluation_result")
public class EvaluationResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "tender_offer_id")
  private Long tenderOfferId;

  @Column(name = "evaluator_id")
  private Long evaluatorId;

  @Column(name = "overall_score")
  private Double overallScore;

  @ElementCollection
  @CollectionTable(name = "criterion_score",
          joinColumns = @JoinColumn(name = "evaluation_result_id"))
  @MapKeyColumn(name = "criterion")
  @Column(name = "score")
  private Map<String, Double> criterionScores;

  // Constructors, getters, setters
}
