package com.egov.tendering.tender.event;


import com.egov.tendering.tender.dal.model.AllocationStrategy;
import com.egov.tendering.tender.dal.model.TenderType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class TenderCreatedEvent extends TenderEvent {
    private Long tendereeId;
    private TenderType type;
    private LocalDateTime submissionDeadline;
    private AllocationStrategy allocationStrategy;
}