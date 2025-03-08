package com.egov.tendering.tender.controller;

import com.egov.tendering.tender.dal.dto.CreateTenderRequest;
import com.egov.tendering.tender.dal.dto.TenderDTO;
import com.egov.tendering.tender.dal.dto.UpdateTenderStatusRequest;
import com.egov.tendering.tender.dal.model.TenderStatus;
import com.egov.tendering.tender.dal.model.TenderType;
import com.egov.tendering.tender.service.TenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/tenders")
@RequiredArgsConstructor
@Slf4j
public class TenderController {

  private final TenderService tenderService;

  @PostMapping
  public ResponseEntity<TenderDTO> createTender(
          @Valid @RequestBody CreateTenderRequest request,
          @RequestHeader("X-User-ID") Long tendereeId) {

    log.info("Received request to create tender: {}", request.getTitle());
    TenderDTO createdTender = tenderService.createTender(request, tendereeId);
    return new ResponseEntity<>(createdTender, HttpStatus.CREATED);
  }

  @GetMapping("/{tenderId}")
  public ResponseEntity<TenderDTO> getTenderById(@PathVariable Long tenderId) {
    log.info("Received request to get tender by ID: {}", tenderId);
    TenderDTO tender = tenderService.getTenderById(tenderId);
    return ResponseEntity.ok(tender);
  }

  @GetMapping
  public ResponseEntity<Page<TenderDTO>> searchTenders(
          @RequestParam(required = false) String title,
          @RequestParam(required = false) TenderStatus status,
          @RequestParam(required = false) TenderType type,
          @PageableDefault(size = 10) Pageable pageable) {

    log.info("Received request to search tenders with title: {}, status: {}, type: {}", title, status, type);
    Page<TenderDTO> tenders = tenderService.searchTenders(title, status, type, pageable);
    return ResponseEntity.ok(tenders);
  }

  @GetMapping("/tenderee")
  public ResponseEntity<Page<TenderDTO>> getTendersByTenderee(
          @RequestHeader("X-User-ID") Long tendereeId,
          @PageableDefault(size = 10) Pageable pageable) {

    log.info("Received request to get tenders by tenderee ID: {}", tendereeId);
    Page<TenderDTO> tenders = tenderService.getTendersByTenderee(tendereeId, pageable);
    return ResponseEntity.ok(tenders);
  }

  @PatchMapping("/{tenderId}/status")
  public ResponseEntity<TenderDTO> updateTenderStatus(
          @PathVariable Long tenderId,
          @Valid @RequestBody UpdateTenderStatusRequest request) {

    log.info("Received request to update tender status: {} for tender ID: {}", request.getStatus(), tenderId);
    TenderDTO updatedTender = tenderService.updateTenderStatus(tenderId, request);
    return ResponseEntity.ok(updatedTender);
  }

  @PostMapping("/{tenderId}/publish")
  public ResponseEntity<TenderDTO> publishTender(@PathVariable Long tenderId) {
    log.info("Received request to publish tender with ID: {}", tenderId);
    TenderDTO publishedTender = tenderService.publishTender(tenderId);
    return ResponseEntity.ok(publishedTender);
  }

  @PostMapping("/{tenderId}/close")
  public ResponseEntity<TenderDTO> closeTender(@PathVariable Long tenderId) {
    log.info("Received request to close tender with ID: {}", tenderId);
    TenderDTO closedTender = tenderService.closeTender(tenderId);
    return ResponseEntity.ok(closedTender);
  }
}