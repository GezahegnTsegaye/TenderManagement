package com.tms.dal.repository;

import com.tms.dal.models.CommunicationHistoryWithTenderee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationHistoryWithTendereeRepository extends JpaRepository<CommunicationHistoryWithTenderee, Long> {
}
