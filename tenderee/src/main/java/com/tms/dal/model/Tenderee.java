package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "tenderee")
public class Tenderee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contactDetailId")
  private ContactDetail contactDetail;

  @Column(name = "address")
  private String address;

  @OneToMany(mappedBy = "tenderee", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Tender> tenderList = new ArrayList<>();

  // constructors, getters, and setters
}
