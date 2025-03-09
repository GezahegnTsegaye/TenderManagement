package com.egov.tendering.evaluation.dal.dto;

import com.egov.tendering.evaluation.dal.model.ReviewStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    @NotNull(message = "Status is required")
    private ReviewStatus status;

    @Size(max = 2000, message = "Comments cannot exceed 2000 characters")
    private String comments;
}