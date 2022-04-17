package com.tms.controller;

import java.util.List;
import java.util.Optional;

import com.tms.model.Administrator;
import org.springframework.web.bind.annotation.GetMapping;

public interface AdministratorController {

	Administrator addAdmin(Administrator administrator);

	List<Administrator> findAll();

	String deleteAdmin(Long id);

}
