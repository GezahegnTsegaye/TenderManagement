package com.tms.controller;

import com.tms.dal.dto.ContactDetailDTO;
import com.tms.service.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/contact-details")
public class ContactDetailControllerImpl implements ContactDetailController {

  private final ContactDetailService contactDetailService;

  @Override
  @GetMapping
  public List<ContactDetailDTO> getAllContactDetails() {
    return contactDetailService.getAllContactDetails();
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ContactDetailDTO> getContactDetailById(@PathVariable Long id) {
    ContactDetailDTO contactDetailDTO = contactDetailService.getContactDetailById(id);
    return ResponseEntity.ok(contactDetailDTO);
  }

  @Override
  @PostMapping
  public ResponseEntity<ContactDetailDTO> createContactDetail(@RequestBody ContactDetailDTO contactDetailDTO) {
    ContactDetailDTO createdContactDetail = contactDetailService.createContactDetail(contactDetailDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdContactDetail);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ContactDetailDTO> updateContactDetail(@PathVariable Long id, @RequestBody ContactDetailDTO contactDetailDTO) {
    ContactDetailDTO updatedContactDetail = contactDetailService.updateContactDetail(id, contactDetailDTO);
    return ResponseEntity.ok(updatedContactDetail);
  }
  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteContactDetail(@PathVariable Long id) {
    contactDetailService.deleteContactDetail(id);
    return ResponseEntity.noContent().build();
  }


}
