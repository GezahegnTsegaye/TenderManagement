package com.tms.services;

import java.util.List;

import com.tms.dal.dto.AdministratorDto;
import com.tms.dal.model.Administrator;

public interface AdministratorService {

    Iterable<AdministratorDto> listAdmin();

    List<Administrator> findAll();

    Administrator addAdmin(Administrator administrator);

    String deleteAdmin(Long id);

}
