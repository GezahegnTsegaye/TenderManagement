package com.tms.controller;

import com.tms.dal.dto.ContractDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContractController {
  @PostMapping
  ContractDTO createContract(@RequestBody ContractDTO contractDTO);

  @GetMapping("/{id}")
  ContractDTO getContractById(@PathVariable Long id);

  @GetMapping
  List<ContractDTO> getAllContracts();

  @DeleteMapping("/{id}")
  void deleteContract(@PathVariable Long id);
}
