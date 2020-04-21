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


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BID")
public @Data class Bid {
	
	@Id
	@GeneratedValue
	@Column(name = "BID_ID")
	private long bidId;
	
	@ManyToOne
	private Tender tender;
	
	@ManyToOne
	private Users users;
	
	@Column(name = "bidAmount")
	private double bidAmount;
	
	@Column(name = "bid_time")
	private Timestamp bidTime;

}
