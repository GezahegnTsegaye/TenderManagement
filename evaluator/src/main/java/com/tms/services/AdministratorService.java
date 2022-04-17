package com.tms.services;

import java.util.List;

import com.tms.dto.AdministratorDto;
import com.tms.model.Administrator;

public interface AdministratorService {

    Iterable<AdministratorDto> listAdmin();

    List<Administrator> findAll();

    Administrator addAdmin(Administrator administrator);

    String deleteAdmin(Long id);

}
