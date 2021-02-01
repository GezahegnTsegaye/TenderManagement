package com.tms.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 
 * @author Gezahegn
 *
 */

@Entity
@Table(name = "administrator", schema = "public")
public @Data class Administrator implements Serializable {

	private  static final long serialVersionUID = 1L;

	@Id
	@Column(name = "administratorId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrator_seq_gen")
	@SequenceGenerator(name = "administrator_seq_gen", sequenceName = "administrator_seq", allocationSize = 1)
	private Long id;

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
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;





}
