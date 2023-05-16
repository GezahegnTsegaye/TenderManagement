package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {
  private Long id;
  private String title;
  private String description;
  private BigDecimal amount;
  private LocalDate startDate;
  private LocalDate endDate;
  private String status;
  private String createdBy;
  private LocalDate createdDate;
  private String updatedBy;
  private LocalDate updatedDate;
  private String deletedBy;
  private LocalDate deletedDate;
  private Long tenderId;
  private Long contractorId;
}
