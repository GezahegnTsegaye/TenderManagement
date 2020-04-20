package com.sample.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Gezahegn Tsegaye
 *
 */

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public @Data class Users {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;

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

}
