package com.tms.service.impl;

import com.tms.dal.dto.TenderDTO;
import com.tms.dal.mapper.TenderMapper;
import com.tms.dal.models.Tender;
import com.tms.dal.repository.TenderRepository;
import com.tms.service.TenderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TenderServiceImpl implements TenderService {

  private final TenderRepository tenderRepository;
  private final TenderMapper tenderMapper;


  @Override
  public List<TenderDTO> getAllTenders() {
    List<Tender> tenders = tenderRepository.findAll();
    return tenderMapper.toDTOList(tenders);
  }

  @Override
  public TenderDTO getTenderById(Long id) {
    Tender tender = tenderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tender not found"));
    return tenderMapper.toDTO(tender);
  }

  @Override
  public TenderDTO createTender(TenderDTO tenderDTO) {
    Tender tender = tenderMapper.toEntity(tenderDTO);
    Tender createdTender = tenderRepository.save(tender);
    return tenderMapper.toDTO(createdTender);
  }

  @Override
  public TenderDTO updateTender(Long id, TenderDTO tenderDTO) {
    Tender existingTender = tenderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tender not found"));

    // Update the attributes of the existing tender with the new values from the DTO
    existingTender.setTenderName(tenderDTO.getTenderName());
    existingTender.setTenderDescription(tenderDTO.getTenderDescription());
    existingTender.setTenderType(tenderDTO.getTenderType());
    existingTender.setTenderStatus(tenderDTO.getTenderStatus());
    existingTender.setTenderStartDate(tenderDTO.getTenderStartDate());
    existingTender.setTenderEndDate(tenderDTO.getTenderEndDate());

    Tender updatedTender = tenderRepository.save(existingTender);
    return tenderMapper.toDTO(updatedTender);
  }

  @Override
  public void deleteTender(Long id) {
    tenderRepository.deleteById(id);
  }

}
