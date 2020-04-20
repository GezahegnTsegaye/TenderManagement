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
 * @author Gezahegn Tsegaye
 *
 */

@Entity
@Table(name = "ADMINISTRATOR")
@NoArgsConstructor
@DiscriminatorValue("Administrator")
public @Data class Administrator extends Users {

	@Id
	@GeneratedValue
	@Column(name = "ADMIN_ID")
	private long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

}
