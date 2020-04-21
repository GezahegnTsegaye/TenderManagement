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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Gezahegn
 *
 */

@Entity
@Table(name = "TENDER")
@NoArgsConstructor
@AllArgsConstructor
public @Data class Tender {

	@Id
	@GeneratedValue
	@Column(name = "TENDER_ID")
	private long tenderId;

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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "tender_Id")
	private List<Tender> tender = new ArrayList<>();
	
	



}
