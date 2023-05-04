package com.tms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "financial_statement")
public class FinancialStatement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "statement_id")
  private Long statementId;

  @Column(name = "statement_year")
  private int statementYear;

  @Column(name = "statement_type")
  private String statementType;

  @Column(name = "revenue")
  private BigDecimal revenue;

  @Column(name = "net_income")
  private BigDecimal netIncome;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tenderer_id")
  private Tenderer tenderer;

  // getters and setters
}
