package com.sample.tms.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "VENDER")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Vender {

	@Id
	@GeneratedValue
	@Column(name = "vender_id")
	private BigDecimal vid;
	@Column(name = "vender_name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_number")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "tin_number")
	private String tinNo;
	@Column(name = "service_tax")
	private String serviceTax;
	@Column(name = "references")
	private String references;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	

}
