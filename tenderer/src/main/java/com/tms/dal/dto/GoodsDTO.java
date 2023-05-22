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
public class GoodsDTO {
  private Long goodsId;
  private String name;
  private String description;
  private int quantity;
  private BigDecimal unitPrice;
  private SupplierDTO supplier;
  private ItemDTO item;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
