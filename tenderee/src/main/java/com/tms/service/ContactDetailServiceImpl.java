package com.tms.service;

import com.tms.dal.dto.ContactDetailDTO;
import com.tms.dal.mapper.ContactDetailMapper;
import com.tms.dal.model.ContactDetail;
import com.tms.dal.repository.ContactDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ContactDetailServiceImpl implements ContactDetailService {


  private final ContactDetailRepository contactDetailRepository;
  private final ContactDetailMapper contactDetailMapper;


  @Override
  public List<ContactDetailDTO> getAllContactDetails() {
    List<ContactDetail> contactDetails = contactDetailRepository.findAll();
    return contactDetailMapper.toDTOList(contactDetails);
  }

  @Override
  public ContactDetailDTO getContactDetailById(Long id) {
    ContactDetail contactDetail = contactDetailRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("ContactDetail not found"));
    return contactDetailMapper.toDTO(contactDetail);
  }
  @Override
  public ContactDetailDTO createContactDetail(ContactDetailDTO contactDetailDTO) {
    ContactDetail contactDetail = contactDetailMapper.toEntity(contactDetailDTO);
    ContactDetail createdContactDetail = contactDetailRepository.save(contactDetail);
    return contactDetailMapper.toDTO(createdContactDetail);
  }

  @Override
  public ContactDetailDTO updateContactDetail(Long id, ContactDetailDTO contactDetailDTO) {
    ContactDetail existingContactDetail = contactDetailRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("ContactDetail not found"));

    // Update the attributes of the existing contact detail with the new values from the DTO
    existingContactDetail.setEmail(contactDetailDTO.getEmail());
    existingContactDetail.setPhoneNumber(contactDetailDTO.getPhoneNumber());
    existingContactDetail.setMobileNumber(contactDetailDTO.getMobileNumber());
    existingContactDetail.setFaxNumber(contactDetailDTO.getFaxNumber());
    existingContactDetail.setPostalAddress(contactDetailDTO.getPostalAddress());
    existingContactDetail.setCity(contactDetailDTO.getCity());
    existingContactDetail.setState(contactDetailDTO.getState());
    existingContactDetail.setStreet(contactDetailDTO.getStreet());
    existingContactDetail.setStreetNumber(contactDetailDTO.getStreetNumber());
    existingContactDetail.setZipCode(contactDetailDTO.getZipCode());
    existingContactDetail.setCountry(contactDetailDTO.getCountry());
    // Set other attributes

    ContactDetail updatedContactDetail = contactDetailRepository.save(existingContactDetail);
    return contactDetailMapper.toDTO(updatedContactDetail);
  }

  @Override
  public void deleteContactDetail(Long id) {
    contactDetailRepository.deleteById(id);
  }
}

