package com.tms.services.impl;

import com.tms.services.BidServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.dal.model.Bid;
import com.tms.dal.repository.BidRepository;

@Service
public class BidServicesImpl implements BidServices {
	
	
	@Autowired
	private BidRepository bidRepository;
	
	
	@Override
	public Bid getBidInformatoin(Bid bid) {
		
		bidRepository.save(bid);
		
		return new Bid();
	}
	
	

}
