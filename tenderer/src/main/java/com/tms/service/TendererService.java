package com.tms.service;

import com.tms.dal.dto.TendererDTO;

import java.util.List;

public interface TendererService {
  List<TendererDTO> getAllTenderers();

  TendererDTO getTendererById(Long id);

  TendererDTO createTenderer(TendererDTO tendererDTO);

  TendererDTO updateTenderer(Long id, TendererDTO tendererDTO);

  void deleteTenderer(Long id);
}
