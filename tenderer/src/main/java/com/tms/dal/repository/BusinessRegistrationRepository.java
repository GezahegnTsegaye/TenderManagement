package com.tms.dal.repository;

import com.tms.dal.models.BusinessRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRegistrationRepository extends JpaRepository<BusinessRegistration, Long> {
}
