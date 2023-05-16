package com.tms.controller;


import com.tms.dal.dto.ContractDTO;
import com.tms.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/contracts")
public class ContractControllerImpl implements ContractController {

  private final ContractService contractService;


  @Override
  @PostMapping
  public ContractDTO createContract(@RequestBody ContractDTO contractDTO) {
    return contractService.saveContract(contractDTO);
  }

  @Override
  @GetMapping("/{id}")
  public ContractDTO getContractById(@PathVariable Long id) {
    return contractService.getContractById(id);
  }

  @Override
  @GetMapping
  public List<ContractDTO> getAllContracts() {
    return contractService.getAllContracts();
  }

  @Override
  @DeleteMapping("/{id}")
  public void deleteContract(@PathVariable Long id) {
    contractService.deleteContract(id);
  }



}
