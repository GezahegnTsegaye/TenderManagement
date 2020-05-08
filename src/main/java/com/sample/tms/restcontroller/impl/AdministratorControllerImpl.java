package com.sample.tms.restcontroller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.tms.restcontroller.AdministratorController;

@RestController
public class AdministratorControllerImpl implements AdministratorController {

	@GetMapping("/")
	public String home() {
		return "This is the world you are exit";
	}

}
