package com.egov.tendering.contract.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MilestoneCompletedEvent extends ContractEvent {
    private Long milestoneId;
    private String milestoneTitle;
    private LocalDate completedDate;
}