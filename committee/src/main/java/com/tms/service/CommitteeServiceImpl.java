package com.tms.service;


import com.tms.dal.model.Committee;
import com.tms.dal.repository.CommitteeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeServiceImpl implements CommitteeService {


  private final CommitteeRepository committeeRepository;

  public CommitteeServiceImpl(CommitteeRepository committeeRepository) {
    this.committeeRepository = committeeRepository;
  }


  @Override
  public List<Committee> getAllCommittees() {
    return committeeRepository.findAll();
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
