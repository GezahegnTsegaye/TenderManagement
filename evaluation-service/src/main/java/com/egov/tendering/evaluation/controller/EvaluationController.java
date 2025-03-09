package com.egov.tendering.evaluation.controller;

import com.egov.tendering.evaluation.dal.dto.EvaluationDTO;
import com.egov.tendering.evaluation.dal.dto.EvaluationRequest;
import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
import com.egov.tendering.evaluation.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
@Slf4j
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("/tenders/{tenderId}")
    public ResponseEntity<EvaluationDTO> createEvaluation(
            @PathVariable Long tenderId,
            @Valid @RequestBody EvaluationRequest request,
            @RequestHeader("X-User-ID") Long evaluatorId) {

        log.info("Creating evaluation for tender ID: {} by event ID: {}", tenderId, evaluatorId);
        EvaluationDTO createdEvaluation = evaluationService.createEvaluation(tenderId, request, evaluatorId);
        return new ResponseEntity<>(createdEvaluation, HttpStatus.CREATED);
    }

    @GetMapping("/{evaluationId}")
    public ResponseEntity<EvaluationDTO> getEvaluationById(@PathVariable Long evaluationId) {
        log.info("Getting evaluation by ID: {}", evaluationId);
        EvaluationDTO evaluation = evaluationService.getEvaluationById(evaluationId);
        return ResponseEntity.ok(evaluation);
    }

    @PutMapping("/{evaluationId}")
    public ResponseEntity<EvaluationDTO> updateEvaluation(
            @PathVariable Long evaluationId,
            @Valid @RequestBody EvaluationRequest request) {

        log.info("Updating evaluation ID: {}", evaluationId);
        EvaluationDTO updatedEvaluation = evaluationService.updateEvaluation(evaluationId, request);
        return ResponseEntity.ok(updatedEvaluation);
    }

    @PatchMapping("/{evaluationId}/status")
    public ResponseEntity<EvaluationDTO> updateEvaluationStatus(
            @PathVariable Long evaluationId,
            @RequestParam EvaluationStatus status) {

        log.info("Updating evaluation ID: {} status to: {}", evaluationId, status);
        EvaluationDTO updatedEvaluation = evaluationService.updateEvaluationStatus(evaluationId, status);
        return ResponseEntity.ok(updatedEvaluation);
    }

}