package com.tms.dal.repository;

import com.tms.dal.model.Tender;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TenderRepository extends JpaRepository<Tender, Long> {
}
