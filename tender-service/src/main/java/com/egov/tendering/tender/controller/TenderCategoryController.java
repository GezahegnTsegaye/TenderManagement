package com.egov.tendering.tender.controller;

import com.egov.tendering.tender.dal.dto.TenderCriteriaDTO;
import com.egov.tendering.tender.service.TenderCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tenderCategory")
@RequiredArgsConstructor
@Slf4j
public class TenderCategoryController  {

  private final TenderCategoryService tenderCategoryService;


  @GetMapping
  public ResponseEntity<List<TenderCriteriaDTO>> getAllTenderCategories() {
    log.info("Fetching all tender categories");
    List<TenderCriteriaDTO> categories = tenderCategoryService.getAllCategories();
    return ResponseEntity.ok(categories);
  }


  @GetMapping("/{id}")
  public ResponseEntity<TenderCriteriaDTO> getTenderCategoryById(@PathVariable Long id) {
    log.info("Fetching tender category with ID: {}", id);
    TenderCriteriaDTO category = tenderCategoryService.getCategoryById(id);
    if (category == null) {
      log.warn("Tender category with ID: {} not found", id);
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(category);
  }


  @PostMapping
  public ResponseEntity<TenderCriteriaDTO> createTenderCategory(@RequestBody TenderCriteriaDTO categoryDTO) {
    log.info("Creating new tender category: {}", categoryDTO.getName());
    TenderCriteriaDTO createdCategory = tenderCategoryService.createCategory(categoryDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
  }


  @PutMapping("/{id}")
  public ResponseEntity<TenderCriteriaDTO> updateTenderCategory(
          @PathVariable Long id, @RequestBody TenderCriteriaDTO categoryDTO) {
    log.info("Updating tender category with ID: {}", id);
    TenderCriteriaDTO updatedCategory = tenderCategoryService.updateCategory(id, categoryDTO);
    if (updatedCategory == null) {
      log.warn("Tender category with ID: {} not found for update", id);
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updatedCategory);
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTenderCategory(@PathVariable Long id) {
    log.info("Deleting tender category with ID: {}", id);
    tenderCategoryService.deleteCategory(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/active")
  public ResponseEntity<List<TenderCriteriaDTO>> getActiveCategories() {
    log.info("Fetching all active tender categories");
    List<TenderCriteriaDTO> activeCategories = tenderCategoryService.findActiveCategories();
    return ResponseEntity.ok(activeCategories);
  }
}