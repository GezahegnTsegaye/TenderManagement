package com.egov.tendering.tender.dal.dto;

import com.egov.tendering.tender.dal.model.AllocationStrategy;
import com.egov.tendering.tender.dal.model.TenderStatus;
import com.egov.tendering.tender.dal.model.TenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderDTO {
  private Long id;
  private String title;
  private String description;
  private Long tendereeId;
  private TenderType type;
  private TenderStatus status;
  private LocalDateTime submissionDeadline;
  private AllocationStrategy allocationStrategy;
  private Integer minWinners;
  private Integer maxWinners;
  private BigDecimal cutoffScore;
  private Boolean isAverageAllocation;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private List<TenderCriteriaDTO> criteria;
  private List<TenderItemDTO> items;
}