package com.tms.service.impl;

import com.tms.dal.dto.SupplierDTO;
import com.tms.dal.mapper.ContactDetailMapper;
import com.tms.dal.mapper.SupplierMapper;
import com.tms.dal.models.ContactDetails;
import com.tms.dal.models.bid.Supplier;
import com.tms.dal.repository.SupplierRepository;
import com.tms.service.SupplierService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService {


  private final SupplierRepository supplierRepository;
  private final SupplierMapper supplierMapper;
  private final ContactDetailMapper contactDetailsMapper;


  @Override
  public List<SupplierDTO> getAllSuppliers() {
    List<Supplier> suppliers = supplierRepository.findAll();
    return supplierMapper.totoDTOList(suppliers);
  }

  @Override
  public SupplierDTO getSupplierById(Long id) {
    Supplier supplier = supplierRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
    return supplierMapper.toDTO(supplier);
  }

  @Override
  public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
    Supplier supplier = supplierMapper.toEntity(supplierDTO);
    ContactDetails contactDetails = contactDetailsMapper.toEntity(supplierDTO.getContactDetails());
    supplier.setContactDetails(contactDetails);
    supplier.setCreatedDate(LocalDateTime.now());
    Supplier createdSupplier = supplierRepository.save(supplier);
    return supplierMapper.toDTO(createdSupplier);
  }

  @Override
  public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
    Supplier existingSupplier = supplierRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));

    supplierMapper.updateEntityFromDTO(supplierDTO, existingSupplier);
    Supplier updatedSupplier = supplierRepository.save(existingSupplier);

    return supplierMapper.toDTO(updatedSupplier);
  }

  @Override
  public void deleteSupplier(Long id) {
    supplierRepository.deleteById(id);
  }


}
