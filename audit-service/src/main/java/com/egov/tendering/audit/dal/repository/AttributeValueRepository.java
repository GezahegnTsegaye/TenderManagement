package com.egov.tendering.audit.dal.repository;

import com.egov.tendering.audit.dal.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {


  AttributeValue findByAttributeName(String attributeName);
}
