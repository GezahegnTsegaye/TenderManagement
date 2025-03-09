package com.egov.tendering.audit.services.impl;

import com.egov.tendering.audit.dal.model.Tender;
import com.egov.tendering.audit.services.TenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egov.tendering.audit.dal.repository.TenderRepository;


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
