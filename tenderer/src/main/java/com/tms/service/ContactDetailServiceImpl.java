package com.tms.service;

import com.tms.dal.repository.ContactDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ContactDetailServiceImpl implements ContactDetailsService {

  private final ContactDetailsRepository contactDetailsRepository;


}
