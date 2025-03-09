package com.egov.tendering.evaluation.dal.repository;

import com.egov.tendering.evaluation.dal.model.AllocationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationResultRepository extends JpaRepository<AllocationResult, Long> {

    List<AllocationResult> findByTenderId(Long tenderId);

    List<AllocationResult> findByBidId(Long bidId);

    List<AllocationResult> findByTenderIdAndBidId(Long tenderId, Long bidId);

    void deleteByTenderId(Long tenderId);
}