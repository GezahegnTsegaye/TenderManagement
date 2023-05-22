package com.tms.controller;

import com.tms.dal.dto.CertificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CertificationsController {
  @GetMapping
  List<CertificationDTO> getAllCertifications();

  @GetMapping("/{id}")
  ResponseEntity<CertificationDTO> getCertificationById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<CertificationDTO> createCertification(@RequestBody CertificationDTO certificationDTO);

  @PutMapping("/{id}")
  ResponseEntity<CertificationDTO> updateCertification(@PathVariable Long id, @RequestBody CertificationDTO certificationDTO);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteCertification(@PathVariable Long id);
}
