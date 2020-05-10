package com.sample.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.tms.entity.Administrator;
import com.sample.tms.repository.AdministratorRepository;
import com.sample.tms.services.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	
	
	
	

}
