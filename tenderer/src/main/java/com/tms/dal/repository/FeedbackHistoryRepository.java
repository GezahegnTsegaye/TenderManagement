package com.tms.dal.repository;

import com.tms.dal.models.FeedbackHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackHistoryRepository extends JpaRepository<FeedbackHistory, Long> {
}
