package com.tms.controller;

import com.tms.dal.model.Administrator;

import java.util.List;

public interface AdministratorController {

	Administrator addAdmin(Administrator administrator);

	List<Administrator> findAll();

	String deleteAdmin(Long id);

}
