package com.egov.tendering.bidding.dal.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidSubmissionRequest {

    @NotNull(message = "Tender ID is required")
    private Long tenderId;

    @NotEmpty(message = "At least one bid item is required")
    @Valid
    private List<BidItemRequest> items;

}