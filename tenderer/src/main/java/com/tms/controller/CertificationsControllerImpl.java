package com.tms.controller;

import com.tms.dal.dto.CertificationDTO;
import com.tms.service.CertificationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/certifications")
public class CertificationsControllerImpl implements CertificationsController {


  private final CertificationsService certificationService;


  @Override
  @GetMapping
  public List<CertificationDTO> getAllCertifications() {
    return certificationService.getAllCertifications();
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<CertificationDTO> getCertificationById(@PathVariable Long id) {
    CertificationDTO certificationDTO = certificationService.getCertificationById(id);
    return ResponseEntity.ok(certificationDTO);
  }

  @Override
  @PostMapping
  public ResponseEntity<CertificationDTO> createCertification(@RequestBody CertificationDTO certificationDTO) {
    CertificationDTO createdCertification = certificationService.createCertification(certificationDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCertification);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<CertificationDTO> updateCertification(@PathVariable Long id, @RequestBody CertificationDTO certificationDTO) {
    CertificationDTO updatedCertification = certificationService.updateCertification(id, certificationDTO);
    return ResponseEntity.ok(updatedCertification);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
    certificationService.deleteCertification(id);
    return ResponseEntity.noContent().build();
  }


}
