package com.tms.controller;

import com.tms.dal.dto.ContactDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContactDetailsController {

  @GetMapping
  List<ContactDetailsDTO> getAllContactDetails();

  @GetMapping("/{id}")
  ResponseEntity<ContactDetailsDTO> getContactDetailById(@PathVariable Long id);

  @PutMapping("/{id}")
  ResponseEntity<ContactDetailsDTO> updateContactDetail(@PathVariable Long id, @RequestBody ContactDetailsDTO contactDetailDTO);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteContactDetail(@PathVariable Long id);
}
