package com.egov.tendering.evaluation.dal.repository;

import com.egov.tendering.evaluation.dal.model.CriteriaScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaScoreRepository extends JpaRepository<CriteriaScore, Long> {

    List<CriteriaScore> findByEvaluationId(Long evaluationId);

    List<CriteriaScore> findByEvaluationIdAndCriteriaId(Long evaluationId, Long criteriaId);
}