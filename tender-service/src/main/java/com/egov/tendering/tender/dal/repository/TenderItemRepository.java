package com.egov.tendering.tender.dal.repository;

import com.egov.tendering.tender.dal.model.TenderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TenderItemRepository extends JpaRepository<TenderItem, Long> {

    List<TenderItem> findByTenderId(Long tenderId);

    List<TenderItem> findByCriteriaId(Long criteriaId);
}