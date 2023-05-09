package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certifications")
public class Certifications {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "certification_id")
  private Long certificationId;

  @Column(name = "certification_name")
  private String certificationName;

  @Column(name = "certification_description")
  private String certificationDescription;

  @Column(name = "certification_authority")
  private String certificationAuthority;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // getters and setters
}

