package com.egov.tendering.audit.dal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 
 * @author Gezahegn
 *
 */

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "administrator")
public class Administrator implements Serializable {

	@Serial
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
