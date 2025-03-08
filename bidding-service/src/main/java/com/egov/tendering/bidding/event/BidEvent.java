package com.egov.tendering.bidding.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BidEvent {
    private Long eventId;
    private String eventType;
    private LocalDateTime timestamp;
    private Long bidId;
    private Long tenderId;
    private Long tendererId;
    private BigDecimal totalPrice;
}