package com.tms.services;

import java.util.List;

import com.tms.model.Administrator;

public interface AdministratorService {

    Iterable<Administrator> listAdmin();

    List<Administrator> findAll();

    Administrator addAdmin(Administrator administrator);

    String deleteAdmin(Long id);

}
