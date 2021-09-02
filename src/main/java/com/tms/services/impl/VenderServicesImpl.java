package com.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.Users;
import com.tms.model.Vender;
import com.tms.repository.VenderRepository;
import com.tms.services.VenderServices;


@Service
public class VenderServicesImpl implements VenderServices {

	
	@Autowired
	private VenderRepository venderRepository;
	
	
	@Override
	public Vender getVender(Vender vender) {
		
		venderRepository.save(vender);
		return new Vender();
	}
	
	
	
}
