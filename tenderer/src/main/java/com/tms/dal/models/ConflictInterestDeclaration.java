package com.tms.dal.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conflict_interest_declaration")
public class ConflictInterestDeclaration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "declaration_id")
  private Long declarationId;

  @Column(name = "declaration_date")
  private LocalDate declarationDate;

  @Column(name = "declaration_description")
  private String declarationDescription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // getters and setters
}
