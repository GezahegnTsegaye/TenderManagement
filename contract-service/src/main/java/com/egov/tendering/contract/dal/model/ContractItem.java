package com.egov.tendering.contract.dal.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contract_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "contract")
public class ContractItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contract_id", nullable = false)
  private Contract contract;  // Corrected from ContractMilestone

  @Column(nullable = false)
  private Long tenderItemId;

  @Column(nullable = false)
  private String name;

  @Column
  private String description;

  @Column(nullable = false)
  private Integer quantity;

  @Column(nullable = false)
  private String unit;

  @Column(nullable = false)
  private BigDecimal unitPrice;

  @Column(nullable = false)
  private BigDecimal totalPrice;
}