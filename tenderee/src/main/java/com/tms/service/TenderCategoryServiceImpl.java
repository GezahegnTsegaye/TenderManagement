package com.tms.service;


import com.tms.dal.mapper.TenderCategoryMapper;
import com.tms.dal.model.TenderCategory;
import com.tms.dal.repository.TenderCategoryRepository;
import com.tms.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TenderCategoryServiceImpl implements TenderCategoryService {

  private final TenderCategoryRepository tenderCategoryRepository;

  private final TenderCategoryMapper tenderCategoryMapper;

  @Override
  public List<TenderCategory> getAllTenderCategories() {
    return tenderCategoryRepository.findAll();
  }

  @Override
  public TenderCategory getTenderCategoryById(Long id) {
    return tenderCategoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tender Category not found with id: " + id));
  }

  @Override
  public TenderCategory createTenderCategory(TenderCategory tenderCategory) {
    return tenderCategoryRepository.save(tenderCategory);
  }

  @Override
  public TenderCategory updateTenderCategory(Long id, TenderCategory updatedTenderCategory) {
    TenderCategory existingTenderCategory = getTenderCategoryById(id);

    existingTenderCategory.setName(updatedTenderCategory.getName());
    existingTenderCategory.setDescription(updatedTenderCategory.getDescription());

    return tenderCategoryRepository.save(existingTenderCategory);
  }

  @Override
  public void deleteTenderCategory(Long id) {
    tenderCategoryRepository.deleteById(id);
  }

}
