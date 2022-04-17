package com.tms.model;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author Gezahegn
 *
 */
@Data
@Entity
@Table(name = "administrator", schema = "public")
public class Administrator implements Serializable {

	private  static final long serialVersionUID = 1L;

	@Id
	@Column(name = "administratorId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrator_seq_gen")
	@SequenceGenerator(name = "administrator_seq_gen", sequenceName = "administrator_seq", allocationSize = 1)
	private Long id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String address;
	private Integer mobileNumber;
	private Integer phoneNumber;
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	private String status;


}
