package com.tms.service;


import com.tms.dal.dto.CommitteeDTO;
import com.tms.dal.mapper.CommitteeMapper;
import com.tms.dal.model.CommitteeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommitteeServiceImpl implements CommitteeService{

  private final CommitteeRepository committeeRepository;
  private final CommitteeMapper committeeMapper;

  @Override
  public void createCommittee(CommitteeDTO  committeeDTO){
    committeeRepository.save(committeeMapper.toEntity(committeeDTO));
  }



}
