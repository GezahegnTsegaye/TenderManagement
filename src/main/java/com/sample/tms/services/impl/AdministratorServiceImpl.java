package com.sample.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.tms.entity.Administrator;
import com.sample.tms.repository.AdministratorRepository;
import com.sample.tms.services.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	@Override
	public Iterable<Administrator> listAdmin() {

		return administratorRepository.findAll();

	}

	@Override
	public Administrator findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator addAdmin(Administrator administrator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAdmin(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
