package com.tms.controller;

import com.tms.dal.model.Committee;
import com.tms.service.CommitteeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/committees")
public class CommitteeControllerImpl implements CommitteController {


  private final CommitteeService committeeService;

  public CommitteeControllerImpl(CommitteeService committeeService) {
    this.committeeService = committeeService;
  }


  @Override
  @GetMapping
  public ResponseEntity<List<Committee>> getAllCommittees() {
    List<Committee> committees = committeeService.getAllCommittees();
    return ResponseEntity.ok(committees);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Committee> getCommitteeById(@PathVariable Long id) {
    Committee committee = committeeService.getCommitteeById(id);
    return ResponseEntity.ok(committee);
  }

  @Override
  @PostMapping
  public ResponseEntity<Committee> createCommittee(@RequestBody Committee committee) {
    Committee createdCommittee = committeeService.createCommittee(committee);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCommittee);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Committee> updateCommittee(@PathVariable Long id, @RequestBody Committee committee) {
    Committee updatedCommittee = committeeService.updateCommittee(id, committee);
    return ResponseEntity.ok(updatedCommittee);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCommittee(@PathVariable Long id) {
    committeeService.deleteCommittee(id);
    return ResponseEntity.noContent().build();
  }


}
