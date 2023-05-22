package com.tms.service;

import com.tms.dal.dto.ContractDTO;

import java.util.List;

public interface ContractService {
  ContractDTO saveContract(ContractDTO contractDTO);

  ContractDTO getContractById(Long id);

  List<ContractDTO> getAllContracts();

  void deleteContract(Long id);
}
