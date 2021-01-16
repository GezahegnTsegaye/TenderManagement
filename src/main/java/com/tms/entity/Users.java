package com.tms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Gezahegn Tsegaye
 *
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "public")
public @Data class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@OneToMany(targetEntity = Bid.class, mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bid> bids = new ArrayList<>();
	
	

}
