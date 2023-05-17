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
public class ItemDTO {
  private Long itemId;
  private String itemName;
  private String itemDescription;
  private BigDecimal itemPrice;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}

