package com.egov.tendering.tender.dal.model;


import jakarta.persistence.*;
import lombok.*;


@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "tender_category")
public class TenderCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String name;
    private String type;
    @Column(name = "category_description")
    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tender_id")
    private Tender tender;

}
