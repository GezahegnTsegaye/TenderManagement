package com.egov.tendering.audit.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tender")
public class Tender {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "deadline")
  private LocalDate deadline;

  @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
  private List<EvaluationCriterion> evaluationCriteria;

  @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL)
  private List<TenderOffer> tenderOffers;

  // Constructors, getters, setters
}
