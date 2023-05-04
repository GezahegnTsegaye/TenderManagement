package com.tms.models;

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
@Table(name = "insurance")
public class Insurance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "insurance_id")
  private Long insuranceId;

  @Column(name = "insurance_type")
  private String insuranceType;

  @Column(name = "insurance_company")
  private String insuranceCompany;

  @Column(name = "policy_number")
  private String policyNumber;

  @Column(name = "expiration_date")
  private LocalDate expirationDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // getters and setters
}
