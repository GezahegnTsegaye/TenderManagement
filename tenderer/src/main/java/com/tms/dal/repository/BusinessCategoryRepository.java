package com.tms.dal.repository;

import com.tms.dal.models.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {

}
