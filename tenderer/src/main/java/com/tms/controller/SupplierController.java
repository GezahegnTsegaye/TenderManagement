package com.tms.controller;

import com.tms.dal.dto.SupplierDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SupplierController {
  @GetMapping
  ResponseEntity<List<SupplierDTO>> getAllSuppliers();

  @GetMapping("/{id}")
  ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO);

  @PutMapping("/{id}")
  ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteSupplier(@PathVariable Long id);
}
