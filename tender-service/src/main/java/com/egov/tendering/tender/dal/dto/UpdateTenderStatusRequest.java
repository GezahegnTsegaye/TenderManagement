package com.egov.tendering.tender.dal.dto;


import com.egov.tendering.tender.dal.model.TenderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTenderStatusRequest {
    @NotNull(message = "Status is required")
    private TenderStatus status;
}
