package com.egov.tendering.notification.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class TenderCreatedEvent extends NotificationEvent {
    private String tenderId;
    private String tenderTitle;
    private LocalDateTime submissionDeadline;

}


