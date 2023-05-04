package com.tms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_detail")
public class ContractDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "contract_id")
  private Long contractId;

  @Column(name = "contract_title")
  private String contractTitle;

  @Column(name = "contract_description")
  private String contractDescription;

  @Column(name = "contract_value")
  private BigDecimal contractValue;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // getters and setters
}
