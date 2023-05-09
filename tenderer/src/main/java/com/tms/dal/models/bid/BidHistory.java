package com.tms.dal.models.bid;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bid_history")
public class BidHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bid_id")
  private Long bidId;

  @Column(name = "bid_submission_date")
  private LocalDateTime bidSubmissionDate;

  @Column(name = "bid_validity_period")
  private LocalDateTime bidValidityPeriod;

  @Column(name = "bid_amount")
  private BigDecimal bidAmount;

  @Column(name = "bid_currency")
  private String bidCurrency;

  @Column(name = "bidder_name")
  private String bidderName;

  @Column(name = "bidder_contact_details")
  private String bidderContactDetails;

  @Column(name = "bid_status")
  private String bidStatus;

  @Column(name = "bid_feedback")
  private String bidFeedback;

  @Column(name = "awarded_bid")
  private boolean awardedBid;

  @Column(name = "contract_amount")
  private BigDecimal contractAmount;

  @Column(name = "contract_start_date")
  private LocalDateTime contractStartDate;

  @Column(name = "contract_end_date")
  private LocalDateTime contractEndDate;

  // getters and setters
}
