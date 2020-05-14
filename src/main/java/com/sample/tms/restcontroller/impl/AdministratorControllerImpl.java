package com.sample.tms.restcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.tms.restcontroller.AdministratorController;
import com.sample.tms.services.AdministratorService;

@RestController
public class AdministratorControllerImpl implements AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	

	@GetMapping("/admin")
	public String home() {
		
		
		return "This is the world you are exit";
	}

}
