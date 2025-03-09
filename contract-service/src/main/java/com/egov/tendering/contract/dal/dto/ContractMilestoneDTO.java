package com.egov.tendering.contract.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractMilestoneDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private BigDecimal paymentAmount;
    private String status;
    private LocalDate completedDate;
}