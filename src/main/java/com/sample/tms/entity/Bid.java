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

import org.springframework.data.jpa.domain.AbstractPersistable;

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
@Table(name = "BID")
public @Data class Bid extends AbstractPersistable<Long> {

	@Column(name = "bidAmount")
	private double bidAmount;

	@Column(name = "bid_time")
	private Timestamp bidTime;

	@Column(name = "trade_licence")
	private String trade_licence;

	@Column(name = "income_tax")
	private String income_tax;

	@Column(name = "published")
	private String published;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "tender_id")
	private Tender tender;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users users;

}
