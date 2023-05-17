package com.tms.service;

import com.tms.dal.model.TenderCategory;

import java.util.List;

public interface TenderCategoryService {
  List<TenderCategory> getAllTenderCategories();

  TenderCategory getTenderCategoryById(Long id);

  TenderCategory createTenderCategory(TenderCategory tenderCategory);

  TenderCategory updateTenderCategory(Long id, TenderCategory updatedTenderCategory);

  void deleteTenderCategory(Long id);
}
