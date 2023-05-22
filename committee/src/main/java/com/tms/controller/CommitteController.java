package com.tms.controller;

import com.tms.dal.dto.CommitteeDTO;
import com.tms.dal.model.Committee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommitteController {

  @GetMapping
  ResponseEntity<List<Committee>> getAllCommittees();

  @GetMapping("/{id}")
  ResponseEntity<Committee> getCommitteeById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<Committee> createCommittee(@RequestBody Committee committee);

  @PutMapping("/{id}")
  ResponseEntity<Committee> updateCommittee(@PathVariable Long id, @RequestBody Committee committee);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteCommittee(@PathVariable Long id);
}
