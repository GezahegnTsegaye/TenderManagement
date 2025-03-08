package com.egov.tendering.user.dal.repository;


import com.egov.tendering.user.dal.model.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserOrganizationRepository extends JpaRepository<UserOrganization, Long> {

    List<UserOrganization> findByUserId(Long userId);

    List<UserOrganization> findByOrganizationId(Long organizationId);

    Optional<UserOrganization> findByUserIdAndOrganizationId(Long userId, Long organizationId);

    boolean existsByUserIdAndOrganizationId(Long userId, Long organizationId);
}