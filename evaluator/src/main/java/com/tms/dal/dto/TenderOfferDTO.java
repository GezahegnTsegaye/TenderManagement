package com.tms.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@AllArgsConstructor@NoArgsConstructor@Getter
public class TenderOfferDTO {

  private Long tenderOfferId;

  private Long vendorId;

  private Double price;

  private String quality;

  private Integer deliveryTime;

  // Constructors, getters, setters
}
