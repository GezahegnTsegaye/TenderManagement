package com.tms.dal.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tenderee")
public class Tenderee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "contact_details")
  private String contactDetails;

  @Column(name = "address")
  private String address;

  @OneToMany(mappedBy = "tenderee", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tender> tenderList = new ArrayList<>();

  // constructors, getters, and setters
}
