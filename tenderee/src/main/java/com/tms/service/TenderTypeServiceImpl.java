package com.tms.service;


import com.tms.dal.mapper.TenderTypeMapper;
import com.tms.dal.repository.TenderTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TenderTypeServiceImpl implements TenderTypeService {

  private final TenderTypeRepository tenderTypeRepository;

  private final TenderTypeMapper tenderTypeMapper;


}
