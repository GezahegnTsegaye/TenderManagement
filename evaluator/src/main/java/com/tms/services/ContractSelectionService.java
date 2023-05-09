package com.tms.services;

import com.tms.dal.dto.ContractDTO;
import com.tms.dal.model.Contract;

public interface ContractSelectionService {

  void createContractSelection(ContractDTO contractDTO);
}
