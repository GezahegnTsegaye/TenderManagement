package com.sample.tms.entity;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Gezahegn Tsegaye
 *
 */


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BID")
public @Data class Bid {
	
	@Id
	@GeneratedValue
	@Column(name = "BID_ID")
	private Long bidId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "tender_Id")
	private List<Tender> tender = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "vender_id")
	private List<Vender> venders = new ArrayList<>();
	
	@Column(name = "bidAmount")
	private double bidAmount;
	@Column(name = "bid_time")
	private Timestamp bidTime;
	
	private String selectBid="Processing";

}
