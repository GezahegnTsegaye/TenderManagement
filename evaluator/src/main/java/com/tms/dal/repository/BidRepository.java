package com.tms.dal.repository;

import com.tms.dal.models.bid.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidRepository extends CrudRepository<Bid, Long> {

}
