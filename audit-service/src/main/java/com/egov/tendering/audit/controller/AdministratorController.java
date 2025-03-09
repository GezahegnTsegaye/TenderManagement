package com.egov.tendering.audit.controller;

import com.egov.tendering.audit.dal.model.Administrator;

import java.util.List;

public interface AdministratorController {

	Administrator addAdmin(Administrator administrator);

	List<Administrator> findAll();

	String deleteAdmin(Long id);

}
