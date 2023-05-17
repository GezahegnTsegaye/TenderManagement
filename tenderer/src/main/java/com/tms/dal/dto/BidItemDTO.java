package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidItemDTO {
  private Long bidItemId;
  private BidDTO bid;
  private ItemDTO item;
  private int quantity;
  private BigDecimal proposedPrice;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
