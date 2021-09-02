package com.tms.repository;

import com.tms.model.Administrator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
	
	List<Administrator> findByAdministratorEmail(String email);

}
