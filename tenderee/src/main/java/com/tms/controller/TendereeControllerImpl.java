package com.tms.controller;

import com.tms.dal.dto.TendereeDTO;
import com.tms.service.TendereeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tenderees")
public class TendereeControllerImpl implements TendereeController {

  private final TendereeService tendereeService;


  @GetMapping
  public List<TendereeDTO> getAllTenderees() {
    return tendereeService.getAllTenderees();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TendereeDTO> getTendereeById(@PathVariable Long id) {
    TendereeDTO tendereeDTO = tendereeService.getTendereeById(id);
    return ResponseEntity.ok(tendereeDTO);
  }

  @PostMapping
  public ResponseEntity<TendereeDTO> createTenderee(@RequestBody TendereeDTO tendereeDTO) {
    TendereeDTO createdTenderee = tendereeService.createTenderee(tendereeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTenderee);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TendereeDTO> updateTenderee(@PathVariable Long id, @RequestBody TendereeDTO tendereeDTO) {
    TendereeDTO updatedTenderee = tendereeService.updateTenderee(id, tendereeDTO);
    return ResponseEntity.ok(updatedTenderee);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTenderee(@PathVariable Long id) {
    tendereeService.deleteTenderee(id);
    return ResponseEntity.noContent().build();
  }

}
