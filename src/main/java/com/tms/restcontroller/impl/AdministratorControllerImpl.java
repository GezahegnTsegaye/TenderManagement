package com.tms.restcontroller.impl;

import java.util.Optional;

import com.tms.entity.Administrator;
import com.tms.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.restcontroller.AdministratorController;

@RestController
@RequestMapping("/admin")
public class AdministratorControllerImpl implements AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@Override
	@GetMapping("/list")
	public Iterable<Administrator> listAdmin() {

		return administratorService.listAdmin();
	}

	@Override
	@PostMapping("/add")
	public Administrator addAdmin(@RequestBody Administrator administrator) {

		return administratorService.addAdmin(administrator);
	}

	@Override
	@GetMapping("/list/{id}")
	public Optional<Administrator> findOne(@PathVariable Long id) {
		return administratorService.findOne(id);
	}

	@Override
	@GetMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		return administratorService.deleteAdmin(id);
	}

}
