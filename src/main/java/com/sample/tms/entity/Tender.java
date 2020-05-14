package com.sample.tms.entity;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Gezahegn
 *
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data class Tender extends AbstractPersistable<Long>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	@Column(name = "tender_name")
	private String tName;

	@Column(name = "opening")
	private Timestamp opening;

	@Column(name = "closing")
	private Timestamp closing;

	@Column(name = "min_bid")
	private Double minBid;

	@Column(name = "tender_description")
	private String tDesc;
	
	@OneToMany(targetEntity = Tender.class, mappedBy = "tender", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Tender> tender = new ArrayList<>();
	
	



}
