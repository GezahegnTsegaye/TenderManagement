package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenderer")
public class Tenderer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tenderer_id")
  private Long tendererId;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "contact_person")
  private String contactPerson;

  @Column(name = "phone")
  private String phone;

  @Column(name = "email")
  private String email;

  @ManyToOne
  @JoinColumn(name = "tenderer_role_id")
  private TendererRole tendererRole;

  @ManyToOne
  @JoinColumn(name = "tenderer_type_id")
  private TendererType tendererType;


  @OneToMany(mappedBy = "tenderer")
  private List<Reference> references;

  @OneToMany(mappedBy = "tenderer")
  private List<FinancialStatement> financialStatements;

  @OneToMany(mappedBy = "tenderer")
  private List<Experience> experiences;

  @OneToMany(mappedBy = "tenderer")
  private List<Insurance> insuranceInformation;

  // getters and setters
}




