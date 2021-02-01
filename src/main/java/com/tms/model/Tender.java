package com.tms.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gezahegn
 *
 */

@Entity
@Table(name = "tender", schema = "public")
public @Data class Tender implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "tenderId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tender_seq_gen")
	@SequenceGenerator(name = "tender_seq_gen", sequenceName = "tender_seq", allocationSize = 1)
	private Long id;

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
	
	@OneToMany(mappedBy = "tender")
	private List<Bid> bids = new ArrayList<>();
	
	



}
