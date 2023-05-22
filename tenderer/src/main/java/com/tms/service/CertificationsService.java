package com.tms.service;

import com.tms.dal.dto.CertificationDTO;

import java.util.List;

public interface CertificationsService {
  List<CertificationDTO> getAllCertifications();

  CertificationDTO getCertificationById(Long id);

  CertificationDTO createCertification(CertificationDTO certificationDTO);

  CertificationDTO updateCertification(Long id, CertificationDTO certificationDTO);

  void deleteCertification(Long id);
}
