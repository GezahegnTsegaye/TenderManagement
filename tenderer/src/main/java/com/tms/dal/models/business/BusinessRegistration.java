package com.tms.dal.models.business;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_registration")
public class BusinessRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "registration_id")
  private Long registrationId;

  @Column(name = "business_name")
  private String businessName;

  @Column(name = "business_address")
  private String businessAddress;

  @Column(name = "business_contact_details")
  private String businessContactDetails;

  @Column(name = "business_registration_date")
  private LocalDate businessRegistrationDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private BusinessCategory businessCategory;

  // getters and setters
}
