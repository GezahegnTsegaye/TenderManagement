package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "evaluation_criterion")
public class EvaluationCriterion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;
  @Column(name = "attribute_name")
  private String attributeName;

  @Column(name = "weight")
  private Double weight;

  @Column(name = "preference")
  @Enumerated(EnumType.STRING)
  private AttributePreference preference;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // Constructors, getters, setters
}
