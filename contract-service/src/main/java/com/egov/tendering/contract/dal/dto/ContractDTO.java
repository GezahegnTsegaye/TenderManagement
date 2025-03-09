package com.egov.tendering.contract.dal.dto;

import com.egov.tendering.contract.dal.model.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractDTO {

  private Long id;
  private Long tenderId;
  private Long bidderId;
  private String contractNumber;
  private String title;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;
  private BigDecimal totalValue;
  private ContractStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String createdBy;
  private String updatedBy;
  private List<ContractItemDTO> items;
  private List<ContractMilestoneDTO> milestones;
}

