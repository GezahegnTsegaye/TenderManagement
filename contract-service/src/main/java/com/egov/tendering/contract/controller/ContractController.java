package com.egov.tendering.contract.controller;

import com.egov.tendering.contract.dal.dto.ContractDTO;
import com.egov.tendering.contract.dal.dto.CreateContractRequest;
import com.egov.tendering.contract.dal.model.ContractStatus;
import com.egov.tendering.contract.service.ContractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
@Slf4j
public class ContractController {

  private final ContractService contractService;

  @PostMapping
  public ResponseEntity<ContractDTO> createContract(
          @Valid @RequestBody CreateContractRequest request,
          @RequestHeader("X-User-ID") String username) {

    log.info("Received request to create contract: {}", request.getTitle());
    ContractDTO createdContract = contractService.createContract(request, username);
    return new ResponseEntity<>(createdContract, HttpStatus.CREATED);
  }

  @GetMapping("/{contractId}")
  public ResponseEntity<ContractDTO> getContractById(@PathVariable Long contractId) {
    log.info("Received request to get contract by ID: {}", contractId);
    ContractDTO contract = contractService.getContractById(contractId);
    return ResponseEntity.ok(contract);
  }

  @GetMapping("/tender/{tenderId}")
  public ResponseEntity<List<ContractDTO>> getContractsByTenderId(@PathVariable Long tenderId) {
    log.info("Received request to get contracts by tender ID: {}", tenderId);
    List<ContractDTO> contracts = contractService.getContractsByTenderId(tenderId);
    return ResponseEntity.ok(contracts);
  }

  @GetMapping("/bidder/{bidderId}")
  public ResponseEntity<Page<ContractDTO>> getContractsByBidderId(
          @PathVariable Long bidderId,
          @PageableDefault(size = 10) Pageable pageable) {

    log.info("Received request to get contracts by bidder ID: {}", bidderId);
    Page<ContractDTO> contracts = contractService.getContractsByBidderId(bidderId, pageable);
    return ResponseEntity.ok(contracts);
  }

  @GetMapping
  public ResponseEntity<Page<ContractDTO>> searchContracts(
          @RequestParam(required = false) String title,
          @RequestParam(required = false) ContractStatus status,
          @RequestParam(required = false) Long tenderId,
          @RequestParam(required = false) Long bidderId,
          @PageableDefault(size = 10) Pageable pageable) {

    log.info("Received request to search contracts with title: {}, status: {}, tenderId: {}, bidderId: {}",
            title, status, tenderId, bidderId);
    Page<ContractDTO> contracts = contractService.searchContracts(title, status, tenderId, bidderId, pageable);
    return ResponseEntity.ok(contracts);
  }

  @PatchMapping("/{contractId}/status")
  public ResponseEntity<ContractDTO> updateContractStatus(
          @PathVariable Long contractId,
          @RequestParam ContractStatus status,
          @RequestHeader("X-User-ID") String username) {

    log.info("Received request to update contract status to {} for contract ID: {}", status, contractId);
    ContractDTO updatedContract = contractService.updateContractStatus(contractId, status, username);
    return ResponseEntity.ok(updatedContract);
  }

  @PostMapping("/{contractId}/activate")
  public ResponseEntity<ContractDTO> activateContract(
          @PathVariable Long contractId,
          @RequestHeader("X-User-ID") String username) {

    log.info("Received request to activate contract with ID: {}", contractId);
    ContractDTO activatedContract = contractService.activateContract(contractId, username);
    return ResponseEntity.ok(activatedContract);
  }

  @PostMapping("/{contractId}/complete")
  public ResponseEntity<ContractDTO> completeContract(
          @PathVariable Long contractId,
          @RequestHeader("X-User-ID") String username) {

    log.info("Received request to complete contract with ID: {}", contractId);
    ContractDTO completedContract = contractService.completeContract(contractId, username);
    return ResponseEntity.ok(completedContract);
  }

  @PostMapping("/{contractId}/terminate")
  public ResponseEntity<ContractDTO> terminateContract(
          @PathVariable Long contractId,
          @RequestParam String reason,
          @RequestHeader("X-User-ID") String username) {

    log.info("Received request to terminate contract with ID: {}", contractId);
    ContractDTO terminatedContract = contractService.terminateContract(contractId, reason, username);
    return ResponseEntity.ok(terminatedContract);
  }
}