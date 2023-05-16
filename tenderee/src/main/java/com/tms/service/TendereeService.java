package com.tms.service;

import com.tms.dal.dto.TendereeDTO;

import java.util.List;

public interface TendereeService {
  List<TendereeDTO> getAllTenderees();

  TendereeDTO getTendereeById(Long id);

  TendereeDTO createTenderee(TendereeDTO tendereeDTO);

  TendereeDTO updateTenderee(Long id, TendereeDTO tendereeDTO);

  void deleteTenderee(Long id);
}
