package com.tms.controller;

import com.tms.dal.dto.ContactDetailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContactDetailController {
  @GetMapping
  List<ContactDetailDTO> getAllContactDetails();

  @GetMapping("/{id}")
  ResponseEntity<ContactDetailDTO> getContactDetailById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<ContactDetailDTO> createContactDetail(@RequestBody ContactDetailDTO contactDetailDTO);

  @PutMapping("/{id}")
  ResponseEntity<ContactDetailDTO> updateContactDetail(@PathVariable Long id, @RequestBody ContactDetailDTO contactDetailDTO);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteContactDetail(@PathVariable Long id);
}
