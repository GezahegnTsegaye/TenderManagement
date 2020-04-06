package com.sample.tms.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.tms.entity.Bid;

public interface BidRepository extends CrudRepository<Bid, Long> {

}
