package com.sample.tms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public @Data class Users extends AbstractPersistable<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "First_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middlename;

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
