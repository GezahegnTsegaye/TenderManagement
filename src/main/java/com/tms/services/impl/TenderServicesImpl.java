package com.tms.services.impl;

import com.tms.services.TenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.model.Tender;
import com.tms.repository.TenderRepository;


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
