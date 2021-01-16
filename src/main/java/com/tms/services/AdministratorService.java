package com.tms.services;

import java.util.Optional;

import com.tms.entity.Administrator;

public interface AdministratorService {

	Iterable<Administrator> listAdmin();
	
	Optional<Administrator> findOne(Long id);
	
	Administrator addAdmin(Administrator administrator);
	
	String deleteAdmin(Long id);

}
