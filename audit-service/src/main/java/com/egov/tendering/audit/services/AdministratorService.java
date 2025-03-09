package com.egov.tendering.audit.services;

import java.util.List;

import com.egov.tendering.audit.dal.dto.AdministratorDto;
import com.egov.tendering.audit.dal.model.Administrator;

public interface AdministratorService {

    Iterable<AdministratorDto> listAdmin();

    List<Administrator> findAll();

    Administrator addAdmin(Administrator administrator);

    String deleteAdmin(Long id);

}
