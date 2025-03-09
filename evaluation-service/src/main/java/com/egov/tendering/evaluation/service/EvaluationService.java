package com.egov.tendering.evaluation.service;

import com.egov.tendering.evaluation.dal.dto.EvaluationDTO;
import com.egov.tendering.evaluation.dal.dto.EvaluationRequest;
import com.egov.tendering.evaluation.dal.dto.TenderEvaluationResult;
import com.egov.tendering.evaluation.dal.model.Evaluation;
import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EvaluationService {

    EvaluationDTO createEvaluation(Long tenderId, EvaluationRequest request, Long evaluatorId);

    EvaluationDTO getEvaluationById(Long evaluationId);

    EvaluationDTO updateEvaluation(Long evaluationId, EvaluationRequest request);

    EvaluationDTO updateEvaluationStatus(Long evaluationId, EvaluationStatus status);

    void deleteEvaluation(Long evaluationId);

    List<EvaluationDTO> getEvaluationsByTender(Long tenderId);

    /**
     * Gets all evaluations for a tender as entities (not DTOs)
     * This is used by the allocation service
     *
     * @param tenderId The tender ID
     * @return List of Evaluation entities
     */
    List<Evaluation> getEvaluationsByTenderId(Long tenderId);

    List<EvaluationDTO> getEvaluationsByBid(Long bidId);

    Page<EvaluationDTO> getEvaluationsByEvaluator(Long evaluatorId, Pageable pageable);

    EvaluationDTO getEvaluationByBidAndEvaluator(Long bidId, Long evaluatorId);

    TenderEvaluationResult calculateTenderResults(Long tenderId);
}