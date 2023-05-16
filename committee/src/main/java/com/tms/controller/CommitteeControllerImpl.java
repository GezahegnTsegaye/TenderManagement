package com.tms.controller;

import com.tms.dal.dto.CommitteeDTO;
import com.tms.service.CommitteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/committees")
public class CommitteeControllerImpl implements CommitteController {

  private final CommitteeService committeeService;


  @Override
  @PostMapping
  public ResponseEntity<Void> createCommittee(@RequestBody CommitteeDTO committeeDTO) {
    committeeService.createCommittee(committeeDTO);
    return ResponseEntity.ok().build();
  }
}
