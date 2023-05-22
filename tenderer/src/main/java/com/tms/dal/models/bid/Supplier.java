package com.tms.dal.models.bid;

import com.tms.dal.models.ContactDetails;
import com.tms.dal.models.Goods;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "supplier_id")
  private Long supplierId;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contactDetailsId")
  private ContactDetails contactDetails;

  @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
  private List<Bid> bids;

  @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
  private List<Goods> goods;

  @CreatedDate
  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  private LocalDateTime lastModifiedDate;

}
