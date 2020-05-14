package com.sample.tms.services;

import com.sample.tms.entity.Administrator;

public interface AdministratorService {

	Iterable<Administrator> listAdmin();
	
	Administrator findOne(Long id);
	
	Administrator addAdmin(Administrator administrator);
	
	String deleteAdmin(Long id);

}
