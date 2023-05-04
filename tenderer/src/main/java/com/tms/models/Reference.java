package com.tms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "reference")
public class Reference {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reference_id")
  private Long referenceId;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // getters and setters
}
