package com.tms.dal.repository;

import com.tms.dal.model.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {




}
