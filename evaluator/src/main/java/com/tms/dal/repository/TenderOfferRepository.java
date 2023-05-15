package com.tms.dal.repository;

import com.tms.dal.model.Criteria;
import com.tms.dal.model.TenderOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TenderOfferRepository extends JpaRepository<TenderOffer, Long> {

  @Query("SELECT t FROM TenderOffer t WHERE t.rftId = :rftId AND t.criteria = :criteria")
  List<TenderOffer> findByRFTIDAndCriterias(@Param("rftId") String rftId, @Param("criteria") Criteria criteria);
  @Query("SELECT t FROM TenderOffer t where t.id = :id and t.criteria = :criteria")
  TenderOffer findByRFTIDAndCriteria(@Param("id") long id, @Param("criteria") Criteria criteria);

}
