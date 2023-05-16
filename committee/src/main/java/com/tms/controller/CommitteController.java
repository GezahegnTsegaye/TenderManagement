package com.tms.controller;

import com.tms.dal.dto.CommitteeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommitteController {
  @PostMapping
  ResponseEntity<Void> createCommittee(@RequestBody CommitteeDTO committeeDTO);
}
