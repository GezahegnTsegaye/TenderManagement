package com.tms.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;

/**
 * 
 * @author Gezahegn
 *
 */


@Entity
@Table(name = "BID", schema = "public")
public @Data class Bid implements Serializable {

	private  static final long serialVersionUID = -8177651785801606912L;

	@Id
	@Column(name = "bidId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_seq_gen")
	@SequenceGenerator(name = "bid_seq_gen", sequenceName = "bid_seq", allocationSize = 1)
	private Long id;

	@Column(name = "bidAmount")
	private double bidAmount;

	@Column(name = "bid_time")
	private Timestamp bidTime;

	@Column(name = "trade_licence")
	private String tradeLicence;

	@Column(name = "income_tax")
	private String incomeTax;

	@Column(name = "published")
	private String published;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tender_id")
	private Tender tender;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id")
	private Users users;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vender_id")
	private Vender vender;

}
