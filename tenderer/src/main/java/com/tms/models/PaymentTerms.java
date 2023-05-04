package com.tms.models;

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
@Table(name = "payment_terms")
public class PaymentTerms {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_terms_id")
  private Long paymentTermsId;

  @Column(name = "payment_terms_description")
  private String paymentTermsDescription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  // getters and setters
}
