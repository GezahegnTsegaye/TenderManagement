package com.tms.service;

import com.tms.dal.repository.ContactDetailsRepository;
import org.springframework.stereotype.Service;



@Service
public class ContactDetailServiceImpl implements ContactDetailsService {

  private final ContactDetailsRepository contactDetailsRepository;


  public ContactDetailServiceImpl(ContactDetailsRepository contactDetailsRepository) {
    this.contactDetailsRepository = contactDetailsRepository;
  }
}
