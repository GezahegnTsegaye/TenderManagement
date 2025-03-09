package com.egov.tendering.contract.dal.repository;

import com.egov.tendering.contract.dal.model.ContractMilestone;
import com.egov.tendering.contract.dal.model.MilestoneStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContractMilestoneRepository extends JpaRepository<ContractMilestone, Long> {

    List<ContractMilestone> findByContractId(Long contractId);

    List<ContractMilestone> findByStatusAndDueDateBefore(MilestoneStatus status, LocalDate currentDate);
}