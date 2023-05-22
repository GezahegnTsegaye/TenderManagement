package com.tms.dal.repository;

import com.tms.dal.models.bid.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
