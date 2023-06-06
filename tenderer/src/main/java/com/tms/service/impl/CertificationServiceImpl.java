package com.tms.service.impl;

import com.tms.dal.dto.CertificationDTO;
import com.tms.dal.mapper.CertificationMapper;
import com.tms.dal.models.Certifications;
import com.tms.dal.repository.CertificationsRepository;
import com.tms.service.CertificationsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CertificationServiceImpl implements CertificationsService {

  private final CertificationsRepository certificationRepository;
  private final CertificationMapper certificationMapper;


  @Override
  public List<CertificationDTO> getAllCertifications() {
    List<Certifications> certifications = certificationRepository.findAll();
    return certificationMapper.toDTOList(certifications);
  }

  @Override
  public CertificationDTO getCertificationById(Long id) {
    Certifications certification = certificationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Certifications not found"));
    return certificationMapper.toDTO(certification);
  }

  @Override
  public CertificationDTO createCertification(CertificationDTO certificationDTO) {
    Certifications certification = certificationMapper.toEntity(certificationDTO);
    Certifications createdCertification = certificationRepository.save(certification);
    return certificationMapper.toDTO(createdCertification);
  }

  @Override
  public CertificationDTO updateCertification(Long id, CertificationDTO certificationDTO) {
    Certifications existingCertification = certificationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Certifications not found"));

    // Update the attributes of the existing certification with the new values from the DTO
    existingCertification.setCertificationName(certificationDTO.getCertificationName());
    existingCertification.setCertificationDescription(certificationDTO.getCertificationDescription());
    existingCertification.setCertificationAuthority(certificationDTO.getCertificationAuthority());

    Certifications updatedCertification = certificationRepository.save(existingCertification);
    return certificationMapper.toDTO(updatedCertification);
  }

  @Override
  public void deleteCertification(Long id) {
    certificationRepository.deleteById(id);
  }


}
