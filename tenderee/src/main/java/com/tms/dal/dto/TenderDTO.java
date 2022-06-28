package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class TenderDTO {

  private Long tenderId;
  private AccountTypeDTO accountTypeDTO;
  private Boolean reBidSubmission;
  private Boolean withdrawalBids;
  private Boolean offlineSubmission;
  private Boolean technicalEvaluation;
  private Boolean multiCurrency;
}
