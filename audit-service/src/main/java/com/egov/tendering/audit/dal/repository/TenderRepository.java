package com.egov.tendering.audit.dal.repository;

import com.egov.tendering.audit.dal.model.Tender;
import org.springframework.data.repository.CrudRepository;

public interface TenderRepository extends CrudRepository<Tender, Long> {

}
