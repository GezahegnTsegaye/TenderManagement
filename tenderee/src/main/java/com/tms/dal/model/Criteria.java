package com.tms.dal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "criteria")
public class Criteria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "weight")
  private Integer weight;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // constructors, getters, and setters
}
