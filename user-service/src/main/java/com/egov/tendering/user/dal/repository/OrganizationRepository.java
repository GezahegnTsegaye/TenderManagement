package com.egov.tendering.user.dal.repository;


import com.egov.tendering.user.dal.model.Organization;
import com.egov.tendering.user.dal.model.OrganizationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByRegistrationNumber(String registrationNumber);

    boolean existsByRegistrationNumber(String registrationNumber);

    Page<Organization> findByStatus(OrganizationStatus status, Pageable pageable);
}