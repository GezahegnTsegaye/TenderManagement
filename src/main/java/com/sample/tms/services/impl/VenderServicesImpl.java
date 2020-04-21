package com.sample.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.tms.entity.Users;
import com.sample.tms.repository.VenderRepository;
import com.sample.tms.services.VenderServices;


@Service
public class VenderServicesImpl implements VenderServices {

	
	@Autowired
	private VenderRepository venderRepository;
	
	
	@Override
	public Users getVender(Users vender) {
		
		venderRepository.save(vender);
		return new Users();
	}
	
	
	
}
