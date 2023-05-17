package com.tms.controller;


import com.tms.dal.dto.SupplierDTO;
import com.tms.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/suppliers")
public class SupplierControllerImpl implements SupplierController {


  private final SupplierService supplierService;


  @Override
  @GetMapping
  public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
    List<SupplierDTO> suppliers = supplierService.getAllSuppliers();
    return ResponseEntity.ok(suppliers);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
    SupplierDTO supplier = supplierService.getSupplierById(id);
    return ResponseEntity.ok(supplier);
  }

  @Override
  @PostMapping
  public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO) {
    SupplierDTO createdSupplier = supplierService.createSupplier(supplierDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplier);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
    SupplierDTO updatedSupplier = supplierService.updateSupplier(id, supplierDTO);
    return ResponseEntity.ok(updatedSupplier);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
    supplierService.deleteSupplier(id);
    return ResponseEntity.noContent().build();
  }


}
