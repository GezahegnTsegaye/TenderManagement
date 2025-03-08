package com.egov.tendering.user.service.impl;


import com.egov.tendering.user.dal.dto.OrganizationDTO;
import com.egov.tendering.user.dal.dto.OrganizationRequest;
import com.egov.tendering.user.dal.mapper.OrganizationMapper;
import com.egov.tendering.user.dal.model.Organization;
import com.egov.tendering.user.dal.model.OrganizationStatus;
import com.egov.tendering.user.dal.model.User;
import com.egov.tendering.user.dal.model.UserOrganization;
import com.egov.tendering.user.event.UserEventPublisher;
import com.egov.tendering.user.exception.DuplicateResourceException;
import com.egov.tendering.user.exception.OrganizationNotFoundException;
import com.egov.tendering.user.exception.UserNotFoundException;

import com.egov.tendering.user.dal.repository.OrganizationRepository;
import com.egov.tendering.user.dal.repository.UserOrganizationRepository;
import com.egov.tendering.user.dal.repository.UserRepository;
import com.egov.tendering.user.service.OrganizationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final UserOrganizationRepository userOrganizationRepository;
    private final OrganizationMapper organizationMapper;
    private final UserEventPublisher eventPublisher;

    @Override
    @Transactional
    public OrganizationDTO createOrganization(OrganizationRequest request, Long creatorUserId) {
        log.info("Creating new organization: {} for user ID: {}", request.getName(), creatorUserId);

        // Check if organization already exists
        if (organizationRepository.existsByRegistrationNumber(request.getRegistrationNumber())) {
            throw new DuplicateResourceException("Organization with registration number already exists: " +
                    request.getRegistrationNumber());
        }

        Organization organization = new Organization();
        organization.setName(request.getName());
        organization.setRegistrationNumber(request.getRegistrationNumber());
        organization.setAddress(request.getAddress());
        organization.setContactPerson(request.getContactPerson());
        organization.setPhone(request.getPhone());
        organization.setEmail(request.getEmail());
        organization.setOrganizationType(request.getOrganizationType());
        organization.setStatus(OrganizationStatus.ACTIVE);

        organization = organizationRepository.save(organization);

        // Add creator to organization
        User creator = userRepository.findById(creatorUserId)
                .orElseThrow(() -> new UserNotFoundException(creatorUserId));

        UserOrganization userOrg = new UserOrganization();
        userOrg.setUser(creator);
        userOrg.setOrganization(organization);
        userOrg.setRole("ADMIN"); // Creator is the admin of the organization

        userOrganizationRepository.save(userOrg);

        // Publish event for organization creation
        eventPublisher.publishOrganizationCreatedEvent(organization);

        return organizationMapper.toDto(organization);
    }

    @Override
    public OrganizationDTO getOrganizationById(Long organizationId) {
        log.info("Getting organization by ID: {}", organizationId);

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        return organizationMapper.toDto(organization);
    }

    @Override
    public OrganizationDTO getOrganizationByRegistrationNumber(String registrationNumber) {
        log.info("Getting organization by registration number: {}", registrationNumber);

        Organization organization = organizationRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new OrganizationNotFoundException("Registration number not found: " + registrationNumber));

        return organizationMapper.toDto(organization);
    }

    @Override
    public Page<OrganizationDTO> getAllOrganizations(Pageable pageable) {
        log.info("Getting all organizations with pagination");

        Page<Organization> organizations = organizationRepository.findAll(pageable);

        return organizations.map(organizationMapper::toDto);
    }

    @Override
    @Transactional
    public OrganizationDTO updateOrganizationStatus(Long organizationId, OrganizationStatus status) {
        log.info("Updating organization status to {} for organization ID: {}", status, organizationId);

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        OrganizationStatus oldStatus = organization.getStatus();
        organization.setStatus(status);
        organization = organizationRepository.save(organization);

        // Publish event for organization status change
        eventPublisher.publishOrganizationStatusChangedEvent(organization, oldStatus);

        return organizationMapper.toDto(organization);
    }

    @Override
    @Transactional
    public void deleteOrganization(Long organizationId) {
        log.info("Deleting organization with ID: {}", organizationId);

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        // Publish event before deletion
        eventPublisher.publishOrganizationDeletedEvent(organization);

        organizationRepository.delete(organization);
    }

    @Override
    public boolean existsByRegistrationNumber(String registrationNumber) {
        return organizationRepository.existsByRegistrationNumber(registrationNumber);
    }

    @Override
    @Transactional
    public void addUserToOrganization(Long userId, Long organizationId, String role) {
        log.info("Adding user ID: {} to organization ID: {} with role: {}", userId, organizationId, role);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        // Check if relationship already exists
        if (userOrganizationRepository.existsByUserIdAndOrganizationId(userId, organizationId)) {
            throw new DuplicateResourceException("User is already associated with this organization");
        }

        UserOrganization userOrg = new UserOrganization();
        userOrg.setUser(user);
        userOrg.setOrganization(organization);
        userOrg.setRole(role);

        userOrganizationRepository.save(userOrg);

        // Publish event for user-organization association
        eventPublisher.publishUserOrganizationChangedEvent(user, organization, "ADDED", role);
    }

    @Override
    @Transactional
    public void removeUserFromOrganization(Long userId, Long organizationId) {
        log.info("Removing user ID: {} from organization ID: {}", userId, organizationId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new OrganizationNotFoundException(organizationId));

        UserOrganization userOrg = userOrganizationRepository.findByUserIdAndOrganizationId(userId, organizationId)
                .orElseThrow(() -> new IllegalStateException("User is not associated with this organization"));

        // Publish event before removal
        eventPublisher.publishUserOrganizationChangedEvent(user, organization, "REMOVED", userOrg.getRole());

        userOrganizationRepository.delete(userOrg);
    }
}