package com.tms.controller.impl;

import java.util.List;

import com.tms.controller.AdministratorController;
import com.tms.dal.model.Administrator;
import com.tms.services.AdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admins")
public class AdministratorControllerImpl implements AdministratorController {

	@Autowired
	private AdministratorService administratorService;


	@Override
	@PostMapping("/add")
	public Administrator addAdmin(@RequestBody Administrator administrator) {

		return administratorService.addAdmin(administrator);
	}

	@Override
	@GetMapping("/list")
	public List<Administrator> findAll() {

		return administratorService.findAll();
	}

	@Override
	@GetMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable Long id) {

		return administratorService.deleteAdmin(id);
	}

}
