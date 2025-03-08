package com.egov.tendering.tender.service;

import com.egov.tendering.tender.dal.dto.TenderCriteriaDTO;
import com.egov.tendering.tender.dal.model.TenderCategory;

import java.util.List;

public interface TenderCategoryService {

  TenderCriteriaDTO createCategory(TenderCriteriaDTO categoryDTO);

  TenderCriteriaDTO getCategoryById(Long id);

  List<TenderCriteriaDTO> getAllCategories();

  TenderCriteriaDTO updateCategory(Long id, TenderCriteriaDTO categoryDTO);

  void deleteCategory(Long id);

  List<TenderCriteriaDTO> findActiveCategories();
}
