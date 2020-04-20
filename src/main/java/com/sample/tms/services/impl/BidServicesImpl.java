package com.sample.tms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.tms.entity.Bid;
import com.sample.tms.repository.BidRepository;
import com.sample.tms.services.BidServices;

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
