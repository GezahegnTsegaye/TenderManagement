package com.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.Users;
import com.tms.repository.VenderRepository;
import com.tms.services.VenderServices;


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
