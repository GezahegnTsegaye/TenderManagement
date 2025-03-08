package com.egov.tendering.tender.service;


import com.egov.tendering.tender.dal.dto.CreateTenderRequest;
import com.egov.tendering.tender.dal.dto.TenderDTO;
import com.egov.tendering.tender.dal.dto.UpdateTenderStatusRequest;
import com.egov.tendering.tender.dal.model.TenderStatus;
import com.egov.tendering.tender.dal.model.TenderType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface TenderService {

  TenderDTO createTender(CreateTenderRequest request, Long tendereeId);

  TenderDTO getTenderById(Long tenderId);

  Page<TenderDTO> searchTenders(String title, TenderStatus status, TenderType type, Pageable pageable);

  Page<TenderDTO> getTendersByTenderee(Long tendereeId, Pageable pageable);

  TenderDTO updateTenderStatus(Long tenderId, UpdateTenderStatusRequest request);

  TenderDTO publishTender(Long tenderId);

  TenderDTO closeTender(Long tenderId);

  void checkForExpiredTenders();
}
