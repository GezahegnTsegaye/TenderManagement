package com.sample.tms.restcontroller;

import java.util.Optional;

import com.sample.tms.entity.Administrator;

public interface AdministratorController {

	Administrator addAdmin(Administrator administrator);

	Iterable<Administrator> listAdmin();
	
	Optional<Administrator> findOne(Long id);
	
	String deleteAdmin(Long id);

}
