package com.egov.tendering.notification.event;

import java.time.LocalDateTime;

public class ContractAwardedEvent extends NotificationEvent {
    private String contractId;
    private String winnerVendorId;
    private LocalDateTime awardDate;
    private String tenderId;
}