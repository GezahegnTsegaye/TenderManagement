package com.egov.tendering.contract.dal.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateContractRequest {

    @NotNull(message = "Tender ID is required")
    private Long tenderId;

    @NotNull(message = "Bidder ID is required")
    private Long bidderId;

    @NotBlank(message = "Contract number is required")
    @Size(max = 50, message = "Contract number must be less than 50 characters")
    private String contractNumber;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    private String description;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    @NotEmpty(message = "At least one contract item is required")
    @Valid
    private List<ContractItemRequest> items;

    @Valid
    private List<ContractMilestoneRequest> milestones;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ContractItemRequest {

        @NotNull(message = "Tender item ID is required")
        private Long tenderItemId;

        @NotBlank(message = "Item name is required")
        private String name;

        private String description;

        @NotNull(message = "Quantity is required")
        private Integer quantity;

        @NotBlank(message = "Unit is required")
        private String unit;

        @NotNull(message = "Unit price is required")
        @DecimalMin(value = "0.01", message = "Unit price must be greater than zero")
        private BigDecimal unitPrice;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ContractMilestoneRequest {

        @NotBlank(message = "Milestone title is required")
        private String title;

        private String description;

        @NotNull(message = "Due date is required")
        private LocalDate dueDate;

        @NotNull(message = "Payment amount is required")
        @DecimalMin(value = "0.01", message = "Payment amount must be greater than zero")
        private BigDecimal paymentAmount;
    }
}