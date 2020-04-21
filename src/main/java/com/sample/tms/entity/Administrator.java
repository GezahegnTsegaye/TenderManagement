package com.sample.tms.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Gezahegn
 *
 */

@Entity
@Table(name = "ADMINISTRATOR")
@NoArgsConstructor
@DiscriminatorValue("Administrator")
public @Data class Administrator {

	@Id
	@GeneratedValue
	@Column(name = "ADMIN_ID")
	private long id;
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
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

}
