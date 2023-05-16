package com.tms.service;


import com.tms.dal.dto.TendereeDTO;
import com.tms.dal.mapper.ContactDetailMapper;
import com.tms.dal.mapper.TendereeMapper;
import com.tms.dal.model.Tenderee;
import com.tms.dal.repository.TendereeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TendereeServiceImpl implements TendereeService {

  private final TendereeRepository tendereeRepository;
  private final TendereeMapper tendereeMapper;
  private final ContactDetailMapper contactDetailMapper;


  @Override
  public List<TendereeDTO> getAllTenderees() {
    List<Tenderee> tenderees = tendereeRepository.findAll();
    return tendereeMapper.toDTOList(tenderees);
  }

  @Override
  public TendereeDTO getTendereeById(Long id) {
    Tenderee tenderee = tendereeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tenderee not found"));
    return tendereeMapper.toDTO(tenderee);
  }

  @Override
  public TendereeDTO createTenderee(TendereeDTO tendereeDTO) {
    Tenderee tenderee = tendereeMapper.toEntity(tendereeDTO);
    Tenderee createdTenderee = tendereeRepository.save(tenderee);
    return tendereeMapper.toDTO(createdTenderee);
  }

  @Override
  public TendereeDTO updateTenderee(Long id, TendereeDTO tendereeDTO) {
    Tenderee existingTenderee = tendereeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tenderee not found"));

    // Update the attributes of the existing tenderee with the new values from the DTO
    existingTenderee.setName(tendereeDTO.getName());
    existingTenderee.setContactDetail(contactDetailMapper.toEntity(tendereeDTO.getContactDetail()));
    existingTenderee.setAddress(tendereeDTO.getAddress());
    // Set other attributes

    Tenderee updatedTenderee = tendereeRepository.save(existingTenderee);
    return tendereeMapper.toDTO(updatedTenderee);
  }

  @Override
  public void deleteTenderee(Long id) {
    tendereeRepository.deleteById(id);
  }


}
