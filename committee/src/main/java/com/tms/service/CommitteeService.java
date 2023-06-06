package com.tms.service;

import com.tms.dal.dto.CommitteeDTO;
import com.tms.dal.model.Committee;

import java.util.List;

public interface CommitteeService {


  List<CommitteeDTO> getAllCommittees();

  Committee getCommitteeById(Long id);

  Committee createCommittee(Committee committee);

  Committee updateCommittee(Long id, Committee committee);

  void deleteCommittee(Long id);
}
