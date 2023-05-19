package com.tms.service.impl;

import com.tms.dal.dto.BusinessRegistrationDTO;
import com.tms.dal.mapper.BusinessCategoryMapper;
import com.tms.dal.mapper.BusinessRegistrationMapper;
import com.tms.dal.models.business.BusinessCategory;
import com.tms.dal.models.business.BusinessRegistration;
import com.tms.dal.repository.BusinessRegistrationRepository;
import com.tms.exception.EntityNotFoundException;
import com.tms.service.BusinessRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessRegistrationServiceImpl implements BusinessRegistrationService {


    private final BusinessRegistrationRepository businessRegistrationRepository;
    private final BusinessRegistrationMapper businessRegistrationMapper;
    private final BusinessCategoryMapper businessCategoryMapper;



    public BusinessRegistrationDTO createBusinessRegistration(BusinessRegistrationDTO businessRegistrationDTO) {
      BusinessRegistration businessRegistration = businessRegistrationMapper.toEntity(businessRegistrationDTO);
      BusinessCategory businessCategory = businessCategoryMapper.toEntity(businessRegistrationDTO.getBusinessCategoryDTO());
      businessRegistration.setBusinessCategory(businessCategory);

      BusinessRegistration savedBusinessRegistration = businessRegistrationRepository.save(businessRegistration);

      return businessRegistrationMapper.toDTO(savedBusinessRegistration);
    }

    public BusinessRegistrationDTO getBusinessRegistrationById(Long id) {
      BusinessRegistration businessRegistration = businessRegistrationRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException("BusinessRegistration not found"));
      return businessRegistrationMapper.toDTO(businessRegistration);
    }

    // Other methods...


}
