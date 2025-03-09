package com.egov.tendering.notification.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BidSubmittedEvent extends NotificationEvent {
    private String bidId;
    private BigDecimal bidAmount;
    private String tenderId;
    private String bidderId;
}