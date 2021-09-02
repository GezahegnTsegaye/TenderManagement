package com.tms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "vender", schema = "public")
public class Vender implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name = "vender_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vender_seq_gen")
	@SequenceGenerator(name = "vender_seq_gen", sequenceName = "vender_seq",allocationSize = 1)
	private Long id;



	@Column(name = "First_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile_number")
	private Integer mobileNumber;

	@Column(name = "phone_number")
	private Integer phoneNumber;
	
	@OneToMany(targetEntity = Bid.class, mappedBy = "users",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bid> bids = new ArrayList<>();
	
	
	
}
