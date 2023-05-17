package com.tms.dal.models;

import com.tms.dal.models.bid.Supplier;
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
@Table(name = "contact_details")
public class ContactDetails {

  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_detail_id_gen")
//  @SequenceGenerator(name = "contact_detail_id_gen", sequenceName = "contact_detail_id_seq", allocationSize = 1)
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
  @Column(name = "street")
  private String street;
  @Column(name = "street_number")
  private int streetNumber;
  @Column(name = "zip_code")
  private String zipCode;
  @Column(name = "country")
  private String country;

  @OneToMany(mappedBy = "contactDetails")
  private List<Supplier> suppliers;

}
