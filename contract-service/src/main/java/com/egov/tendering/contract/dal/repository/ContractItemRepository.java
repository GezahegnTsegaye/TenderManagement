package com.egov.tendering.contract.dal.repository;

import com.egov.tendering.contract.dal.model.ContractItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractItemRepository extends JpaRepository<ContractItem, Long> {

    List<ContractItem> findByContractId(Long contractId);
}