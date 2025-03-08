package com.egov.tendering.tender.event;


import com.egov.tendering.tender.dal.model.TenderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class TenderStatusChangedEvent extends TenderEvent {
    private TenderStatus oldStatus;
    private TenderStatus newStatus;
}
