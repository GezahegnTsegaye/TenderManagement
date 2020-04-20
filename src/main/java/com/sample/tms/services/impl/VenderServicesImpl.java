package com.sample.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.tms.entity.Vender;
import com.sample.tms.repository.VenderRepository;
import com.sample.tms.services.VenderServices;


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
