package com.tms.service;

import com.tms.dal.dto.TendererDTO;
import com.tms.dal.mapper.TendererMapper;
import com.tms.dal.models.Tenderer;
import com.tms.dal.repository.TendererRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TendererServiceImpl implements TendererService {


  private final TendererRepository tendererRepository;
  private final TendererMapper tendererMapper;


  @Override
  public List<TendererDTO> getAllTenderers() {
    return tendererMapper.toDTOList(tendererRepository.findAll());
  }

  @Override
  public TendererDTO getTendererById(Long id) {
    Tenderer tenderer = tendererRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tenderer not found"));
    return tendererMapper.toDTO(tenderer);
  }

  @Override
  public TendererDTO createTenderer(TendererDTO tendererDTO) {
    Tenderer tenderer = tendererMapper.toEntity(tendererDTO);
    Tenderer createdTenderer = tendererRepository.save(tenderer);
    return tendererMapper.toDTO(createdTenderer);
  }

  @Override
  public TendererDTO updateTenderer(Long id, TendererDTO tendererDTO) {
    Tenderer existingTenderer = tendererRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Tenderer not found"));

    existingTenderer.setName(tendererDTO.getName());
    existingTenderer.setAddress(tendererDTO.getAddress());
    existingTenderer.setContactPerson(tendererDTO.getContactPerson());
    existingTenderer.setPhone(tendererDTO.getPhone());
    existingTenderer.setEmail(tendererDTO.getEmail());

    Tenderer updatedTenderer = tendererRepository.save(existingTenderer);
    return tendererMapper.toDTO(updatedTenderer);
  }

  @Override
  public void deleteTenderer(Long id) {
    tendererRepository.deleteById(id);
  }

}
