package com.egov.tendering.user.service;


import com.egov.tendering.user.dal.dto.OrganizationDTO;
import com.egov.tendering.user.dal.dto.OrganizationRequest;
import com.egov.tendering.user.dal.model.OrganizationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface OrganizationService {

    OrganizationDTO createOrganization(OrganizationRequest request, Long creatorUserId);

    OrganizationDTO getOrganizationById(Long organizationId);

    OrganizationDTO getOrganizationByRegistrationNumber(String registrationNumber);

    Page<OrganizationDTO> getAllOrganizations(Pageable pageable);

    OrganizationDTO updateOrganizationStatus(Long organizationId, OrganizationStatus status);

    void deleteOrganization(Long organizationId);

    boolean existsByRegistrationNumber(String registrationNumber);

    void addUserToOrganization(Long userId, Long organizationId, String role);

    void removeUserFromOrganization(Long userId, Long organizationId);
}