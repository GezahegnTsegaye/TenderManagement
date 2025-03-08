package com.egov.tendering.tender.dal.repository;


import com.egov.tendering.tender.dal.model.TenderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TenderCategoryRepository extends JpaRepository<TenderCategory, Long> {

    /**
     * Find all tender categories with a specific name
     */
    List<TenderCategory> findByName(String name);

    /**
     * Find all active tender categories
     */
    List<TenderCategory> findByActiveTrue();

    /**
     * Find categories that belong to a specific tender
     */
    List<TenderCategory> findByTenderId(Long tenderId);

    /**
     * Check if a category with this name already exists
     */
    boolean existsByName(String name);

    /**
     * Find categories by type
     */
    List<TenderCategory> findByType(String type);

    /**
     * Custom query to find categories that match certain criteria
     */
    List<TenderCategory> findByNameContainingIgnoreCaseAndActiveTrue(String nameFragment);
}