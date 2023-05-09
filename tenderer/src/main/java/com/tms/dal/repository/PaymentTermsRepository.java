package com.tms.dal.repository;

import com.tms.dal.models.PaymentTerms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTermsRepository extends JpaRepository<PaymentTerms, Long> {
}
