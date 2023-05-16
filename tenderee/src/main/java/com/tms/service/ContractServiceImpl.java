package com.tms.service;

import com.tms.dal.dto.ContractDTO;
import com.tms.dal.mapper.ContractMapper;
import com.tms.dal.model.Contract;
import com.tms.dal.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

  private final ContractRepository contractRepository;
  private final ContractMapper contractMapper;

  @Override
  public ContractDTO saveContract(ContractDTO contractDTO) {
    Contract contract = contractMapper.toEntity(contractDTO);
    Contract savedContract = contractRepository.save(contract);
    return contractMapper.toDTO(savedContract);
  }

  @Override
  public ContractDTO getContractById(Long id) {
    Contract contract = contractRepository.findById(id).orElse(null);
    return contractMapper.toDTO(contract);
  }

  @Override
  public List<ContractDTO> getAllContracts() {
    List<Contract> contracts = contractRepository.findAll();
    return contractMapper.toDTOList(contracts);
  }

  @Override
  public void deleteContract(Long id) {
    contractRepository.deleteById(id);
  }

}
