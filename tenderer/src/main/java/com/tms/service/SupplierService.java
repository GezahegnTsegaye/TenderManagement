package com.tms.service;

import com.tms.dal.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
  List<SupplierDTO> getAllSuppliers();

  SupplierDTO getSupplierById(Long id);

  SupplierDTO createSupplier(SupplierDTO supplierDTO);

  SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO);

  void deleteSupplier(Long id);
}
