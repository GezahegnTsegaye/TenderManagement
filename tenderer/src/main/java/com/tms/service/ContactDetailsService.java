package com.tms.service;

import com.tms.dal.dto.ContactDetailsDTO;

import java.util.List;

public interface ContactDetailsService {
  ContactDetailsDTO saveContactDetail(ContactDetailsDTO contactDetailDTO);

  ContactDetailsDTO getContactDetailById(Long id);

  List<ContactDetailsDTO> getAllContactDetails();

  ContactDetailsDTO updateContactDetail(Long id, ContactDetailsDTO contactDetailDTO);

  void deleteContactDetail(Long id);
}
