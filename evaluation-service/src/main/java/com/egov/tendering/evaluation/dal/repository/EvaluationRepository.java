package com.egov.tendering.evaluation.dal.repository;

import com.egov.tendering.evaluation.dal.model.Evaluation;
import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findByTenderIdAndStatus(Long tenderId, EvaluationStatus status);

    List<Evaluation> findByTenderId(Long tenderId);

    List<Evaluation> findByBidId(Long bidId);

    List<Evaluation> findByEvaluatorId(Long evaluatorId);

    Optional<Evaluation> findByBidIdAndEvaluatorId(Long bidId, Long evaluatorId);
}