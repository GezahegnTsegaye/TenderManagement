package com.egov.tendering.audit.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_detail")
public class ContactDetail {

  @Id
  @Column(name = "contact_detail_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_detail_id_gen")
  @SequenceGenerator(name = "contact_detail_id_gen", sequenceName = "contact_detail_id_seq", allocationSize = 1)
  private Long contactId;
  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "mobile_number")
  private String mobileNumber;

  @Column(name = "fax_number")
  private String faxNumber;

  @Column(name = "postal_address")
  private String postalAddress;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "zip_code")
  private String zipCode;

  @Column(name = "country")
  private String country;
}
