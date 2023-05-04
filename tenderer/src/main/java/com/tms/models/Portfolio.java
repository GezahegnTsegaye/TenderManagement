package com.tms.models;

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
@Table(name = "portfolio")
public class Portfolio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "portfolio_id")
  private Long portfolioId;

  @Column(name = "portfolio_name")
  private String portfolioName;

  @Column(name = "portfolio_description")
  private String portfolioDescription;

  @Column(name = "portfolio_url")
  private String portfolioUrl;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // getters and setters
}
