package com.egov.tendering.bidding.dal.dto;

import com.egov.tendering.bidding.dal.model.RequirementType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceRequirementDTO {
    private Long id;
    private Long tenderId;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Mandatory flag is required")
    private Boolean mandatory;

    @NotNull(message = "Requirement type is required")
    private RequirementType type;

    private Long criteriaId;
    private String keyword;
}