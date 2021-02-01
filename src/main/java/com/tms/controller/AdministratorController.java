package com.tms.controller;

import java.util.Optional;

import com.tms.model.Administrator;

public interface AdministratorController {

	Administrator addAdmin(Administrator administrator);

	Iterable<Administrator> listAdmin();
	
	Optional<Administrator> findOne(Long id);
	
	String deleteAdmin(Long id);

}
