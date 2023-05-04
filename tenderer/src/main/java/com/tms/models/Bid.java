package com.tms.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bid")
public class Bid {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "price")
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // constructors, getters, and setters
}
