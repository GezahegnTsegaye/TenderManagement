package com.tms.service.impl;


import com.tms.dal.dto.BidHistoryDTO;
import com.tms.dal.mapper.BidHistoryMapper;
import com.tms.dal.models.bid.BidHistory;
import com.tms.dal.repository.BidHistoryRepository;
import com.tms.service.BidHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BidHistoryServiceImpl implements BidHistoryService {

  private final BidHistoryRepository bidHistoryRepository;
  private final BidHistoryMapper bidHistoryMapper;


  public void getBidHistory(BidHistoryDTO bidHistoryDTO){

  }
}
