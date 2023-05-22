package com.tms.service;

import com.tms.dal.dto.ContactDetailsDTO;
import com.tms.dal.mapper.ContactDetailMapper;
import com.tms.dal.models.ContactDetails;
import com.tms.dal.repository.ContactDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ContactDetailServiceImpl implements ContactDetailsService {

  private final ContactDetailsRepository contactDetailRepository;
  private final ContactDetailMapper contactDetailMapper;


  @Override
  public ContactDetailsDTO saveContactDetail(ContactDetailsDTO contactDetailDTO) {
    ContactDetails contactDetail = contactDetailMapper.toEntity(contactDetailDTO);
    ContactDetails savedContactDetail = contactDetailRepository.save(contactDetail);
    return contactDetailMapper.toDTO(savedContactDetail);
  }

  @Override
  public ContactDetailsDTO getContactDetailById(Long id) {
    ContactDetails contactDetail = contactDetailRepository.findById(id).orElse(null);
    return contactDetailMapper.toDTO(contactDetail);
  }
  @Override
  public List<ContactDetailsDTO> getAllContactDetails() {
    List<ContactDetails> contactDetails = contactDetailRepository.findAll();
    return contactDetailMapper.toDTOList(contactDetails);
  }

  @Override
  public ContactDetailsDTO updateContactDetail(Long id, ContactDetailsDTO contactDetailDTO) {
    ContactDetails existingContactDetail = contactDetailRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("ContactDetail not found"));

    ContactDetails updatedContactDetail = contactDetailMapper.updateEntityFromDTO(contactDetailDTO, existingContactDetail);
    updatedContactDetail = contactDetailRepository.save(updatedContactDetail);

    return contactDetailMapper.toDTO(updatedContactDetail);
  }
  @Override
  public void deleteContactDetail(Long id) {
    contactDetailRepository.deleteById(id);
  }
}
