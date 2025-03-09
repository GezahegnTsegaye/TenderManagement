package com.egov.tendering.contract.event;

import com.egov.tendering.contract.dal.model.ContractStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContractStatusChangedEvent extends ContractEvent {
    private ContractStatus oldStatus;
    private ContractStatus newStatus;
}