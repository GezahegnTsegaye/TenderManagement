package com.tms.dal.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "contract")
public class Contract {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "amount")
  private BigDecimal amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contractor_id")
  private Contractor contractor;

  // constructors, getters, and setters
}
