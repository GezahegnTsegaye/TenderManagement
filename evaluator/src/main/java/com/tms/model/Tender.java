package com.tms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author Gezahegn
 *
 */

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "tender")
public class Tender implements Serializable {

	
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
	private LocalDateTime opening;

	@Column(name = "closing")
	private LocalDateTime closing;

	@Column(name = "min_bid")
	private Double minBid;

	@Column(name = "tender_description")
	private String tDesc;
	
	@OneToMany(mappedBy = "tender")
	private List<Bid> bids;
	
	



}
