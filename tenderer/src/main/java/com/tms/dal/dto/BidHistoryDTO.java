package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class BidHistoryDTO {
  private Long bidHistoryId;
  private LocalDateTime bidSubmissionDate;
  private LocalDateTime bidValidityPeriod;
  private BigDecimal bidAmount;
  private String bidCurrency;
  private String bidderName;
  private String bidderContactDetails;
  private String bidStatus;
  private String bidFeedback;
  private boolean awardedBid;
  private BigDecimal contractAmount;
  private LocalDateTime contractStartDate;
  private LocalDateTime contractEndDate;
}
