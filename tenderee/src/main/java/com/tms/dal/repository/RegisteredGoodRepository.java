package com.tms.dal.repository;

import com.tms.dal.model.RegisteredGood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredGoodRepository extends JpaRepository<RegisteredGood, Long> {
}
