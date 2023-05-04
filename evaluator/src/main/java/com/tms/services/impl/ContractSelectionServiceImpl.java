package com.tms.services.impl;

import com.tms.dal.repository.ContractRepository;
import com.tms.services.ContractSelectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContractSelectionServiceImpl implements ContractSelectionService {

  private final ContractRepository contractRepository;
}
