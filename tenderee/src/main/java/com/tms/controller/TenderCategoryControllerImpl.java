package com.tms.controller;

import com.tms.dal.model.TenderCategory;
import com.tms.service.TenderCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/tenderCategory")
public class TenderCategoryControllerImpl implements TenderCategoryController {


  private final TenderCategoryService tenderCategoryService;


  @Override
  @GetMapping
  public ResponseEntity<List<TenderCategory>> getAllTenderCategories() {
    List<TenderCategory> tenderCategories = tenderCategoryService.getAllTenderCategories();
    return ResponseEntity.ok(tenderCategories);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TenderCategory> getTenderCategoryById(@PathVariable Long id) {
    TenderCategory tenderCategory = tenderCategoryService.getTenderCategoryById(id);
    return ResponseEntity.ok(tenderCategory);
  }

  @Override
  @PostMapping
  public ResponseEntity<TenderCategory> createTenderCategory(@RequestBody TenderCategory tenderCategory) {
    TenderCategory createdTenderCategory = tenderCategoryService.createTenderCategory(tenderCategory);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTenderCategory);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<TenderCategory> updateTenderCategory(
          @PathVariable Long id, @RequestBody TenderCategory updatedTenderCategory) {
    TenderCategory updatedCategory = tenderCategoryService.updateTenderCategory(id, updatedTenderCategory);
    return ResponseEntity.ok(updatedCategory);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTenderCategory(@PathVariable Long id) {
    tenderCategoryService.deleteTenderCategory(id);
    return ResponseEntity.noContent().build();
  }


}
