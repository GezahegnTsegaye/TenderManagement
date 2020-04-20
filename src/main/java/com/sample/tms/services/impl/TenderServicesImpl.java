package com.sample.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import com.sample.tms.entity.Tender;
import com.sample.tms.repository.TenderRepository;
import com.sample.tms.services.TenderServices;


@Service
public class TenderServicesImpl implements TenderServices {
	
	
	@Autowired
	private TenderRepository tenderRepository;
	
	
	@Override
	public Tender getTender(Tender tender) {
		tenderRepository.save(tender);
		return new Tender();
	}

}
