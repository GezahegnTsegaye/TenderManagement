package com.sample.tms.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.tms.entity.Tender;

public interface TenderRepository extends CrudRepository<Tender, Long> {

}
