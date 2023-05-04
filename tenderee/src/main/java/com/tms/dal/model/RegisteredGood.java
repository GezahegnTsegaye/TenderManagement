package com.tms.dal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registered_good")
public class RegisteredGood {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "quantity")
  private Integer quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // constructors, getters, and setters
}
