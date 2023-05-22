package com.tms.controller;

import com.tms.dal.dto.ContactDetailsDTO;
import com.tms.service.ContactDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/contactDetails")
public class ContactDetailsControllerImpl implements ContactDetailsController {


  private final ContactDetailsService contactDetailsService;


  @Override
  @GetMapping
  public List<ContactDetailsDTO> getAllContactDetails() {
    return contactDetailsService.getAllContactDetails();
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ContactDetailsDTO> getContactDetailById(@PathVariable Long id) {
    ContactDetailsDTO contactDetailDTO = contactDetailsService.getContactDetailById(id);
    return ResponseEntity.ok(contactDetailDTO);
  }

  @PostMapping
  public ResponseEntity<ContactDetailsDTO> createContactDetail(@RequestBody ContactDetailsDTO contactDetailDTO) {
    ContactDetailsDTO createdContactDetail = contactDetailsService.saveContactDetail(contactDetailDTO);
    return ResponseEntity.ok(createdContactDetail);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ContactDetailsDTO> updateContactDetail(@PathVariable Long id, @RequestBody ContactDetailsDTO contactDetailDTO) {
    ContactDetailsDTO updatedContactDetail = contactDetailsService.updateContactDetail(id, contactDetailDTO);
    return ResponseEntity.ok(updatedContactDetail);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteContactDetail(@PathVariable Long id) {
    contactDetailsService.deleteContactDetail(id);
    return ResponseEntity.noContent().build();
  }


}
