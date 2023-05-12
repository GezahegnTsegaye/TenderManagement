package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class BusinessCategoryDTO {
  private Long categoryId;
  private String categoryName;
  private String categoryDescription;
}
