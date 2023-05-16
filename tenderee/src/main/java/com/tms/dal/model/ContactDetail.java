package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_detail")
public class ContactDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "contact_id")
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
  private String street;
  private int streetNumber;
  @Column(name = "zip_code")
  private String zipCode;

  @Column(name = "country")
  private String country;

  @OneToMany(mappedBy = "contactDetail")
  private List<Tenderee> tenderees;

}
