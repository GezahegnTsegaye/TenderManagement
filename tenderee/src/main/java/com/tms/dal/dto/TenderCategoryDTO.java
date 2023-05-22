package com.tms.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class TenderCategoryDTO {

  private Long tenderCategoryId;
  private String categoryName;
  private String description;
}
