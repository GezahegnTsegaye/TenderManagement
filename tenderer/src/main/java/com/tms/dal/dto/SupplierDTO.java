package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
  private Long supplierId;
  private String name;
  private String address;
  private ContactDetailsDTO contactDetails;
  private List<BidDTO> bids;
  private List<GoodsDTO> goods;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}

