package com.tms.dal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goods", indexes = {
        @Index(name = "idx_goods_name", columnList = "goods_name")
})
public class Goods {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "goods_id")
  private Long goodsId;

  @Column(name = "goods_name")
  private String goodsName;

  @Column(name = "goods_description")
  private String goodsDescription;

  @Column(name = "unit_price")
  private BigDecimal unitPrice;

  @Column(name = "quantity")
  private int quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tender_id")
  private Tender tender;

  @CreatedDate
  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  private LocalDateTime lastModifiedDate;

// getters and setters
}
