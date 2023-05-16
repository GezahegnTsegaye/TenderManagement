package com.tms.dal.repository;

import com.tms.dal.models.Tenderer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TendererRepository extends JpaRepository<Tenderer, Long> {
}
