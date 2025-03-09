package com.egov.tendering.contract.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ContractEvent {
    private Long eventId;
    private String eventType;
    private LocalDateTime timestamp;
    private Long contractId;
    private String contractNumber;
    private String title;
}