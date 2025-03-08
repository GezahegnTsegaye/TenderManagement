package com.egov.tendering.bidding.dal.dto;


import com.egov.tendering.bidding.dal.model.SecurityType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidSecurityRequest {

    @NotNull(message = "Security type is required")
    private SecurityType type;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Issuer name is required")
    private String issuerName;

    @NotBlank(message = "Reference number is required")
    private String referenceNumber;

    @NotNull(message = "Issue date is required")
    @PastOrPresent(message = "Issue date cannot be in the future")
    private LocalDate issueDate;

    @NotNull(message = "Expiry date is required")
    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;
}