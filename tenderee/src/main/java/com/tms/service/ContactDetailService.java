package com.tms.service;

import com.tms.dal.dto.ContactDetailDTO;

import java.util.List;

public interface ContactDetailService {
  List<ContactDetailDTO> getAllContactDetails();

  ContactDetailDTO getContactDetailById(Long id);

  ContactDetailDTO createContactDetail(ContactDetailDTO contactDetailDTO);

  ContactDetailDTO updateContactDetail(Long id, ContactDetailDTO contactDetailDTO);

  void deleteContactDetail(Long id);
}
