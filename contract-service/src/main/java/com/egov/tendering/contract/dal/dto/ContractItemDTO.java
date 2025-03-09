package com.egov.tendering.contract.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractItemDTO {

    private Long id;
    private Long tenderItemId;
    private String name;
    private String description;
    private Integer quantity;
    private String unit;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
