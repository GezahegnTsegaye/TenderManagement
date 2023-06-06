package com.tms.service;


import com.tms.dal.dto.CommitteeDTO;
import com.tms.dal.mapper.CommitteeMapper;
import com.tms.dal.model.Committee;
import com.tms.dal.repository.CommitteeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CommitteeServiceImpl implements CommitteeService {


  private final CommitteeRepository committeeRepository;
  private final CommitteeMapper committeeMapper;




  @Override
  public List<CommitteeDTO> getAllCommittees() {
    List<Committee> committees = committeeRepository.findAll();


    return committeeMapper.toDTOList(committees);
  }

  @Override
  public Committee getCommitteeById(Long id) {
    return committeeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Committee not found"));
  }

  @Override
  public Committee createCommittee(Committee committee) {
    return committeeRepository.save(committee);
  }

  @Override
  public Committee updateCommittee(Long id, Committee committee) {
    Committee existingCommittee = committeeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Committee not found"));

    existingCommittee.setFirstName(committee.getFirstName());
    existingCommittee.setLastName(committee.getLastName());
    existingCommittee.setEmployeePosition(committee.getEmployeePosition());
    existingCommittee.setAddress(committee.getAddress());

    return committeeRepository.save(existingCommittee);
  }

  @Override
  public void deleteCommittee(Long id) {
    committeeRepository.deleteById(id);
  }


}
