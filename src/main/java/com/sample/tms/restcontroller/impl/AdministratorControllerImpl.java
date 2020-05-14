package com.sample.tms.restcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.tms.entity.Administrator;
import com.sample.tms.restcontroller.AdministratorController;
import com.sample.tms.services.AdministratorService;

@RestController
@RequestMapping("/admin")
public class AdministratorControllerImpl implements AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	

	@GetMapping("/list")
	public Iterable<Administrator> listAdmin() {
		
		
		return administratorService.listAdmin();
	}

}
