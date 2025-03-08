package com.egov.tendering.bidding.event;


import com.egov.tendering.bidding.dal.model.BidStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class BidStatusChangedEvent extends BidEvent {
    private BidStatus oldStatus;
    private BidStatus newStatus;
}