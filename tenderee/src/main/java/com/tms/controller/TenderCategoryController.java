package com.tms.controller;

import com.tms.dal.model.TenderCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TenderCategoryController {
  @GetMapping
  ResponseEntity<List<TenderCategory>> getAllTenderCategories();

  @GetMapping("/{id}")
  ResponseEntity<TenderCategory> getTenderCategoryById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<TenderCategory> createTenderCategory(@RequestBody TenderCategory tenderCategory);

  @PutMapping("/{id}")
  ResponseEntity<TenderCategory> updateTenderCategory(
          @PathVariable Long id, @RequestBody TenderCategory updatedTenderCategory);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteTenderCategory(@PathVariable Long id);
}
