package com.tms.service;

import com.tms.dal.dto.TenderDTO;

import java.util.List;

public interface TenderService {
  List<TenderDTO> getAllTenders();

  TenderDTO getTenderById(Long id);

  TenderDTO createTender(TenderDTO tenderDTO);

  TenderDTO updateTender(Long id, TenderDTO tenderDTO);

  void deleteTender(Long id);
}
