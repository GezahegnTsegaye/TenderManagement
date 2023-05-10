package com.tms.dal.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter@Getter @NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tender")
public class Tender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "closing_date")
    private LocalDateTime closingDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenderTypeId")
    private TenderType tenderType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenderee_id")
    private Tenderee tenderee;

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Criteria> criteriaList = new ArrayList<>();

    @OneToMany(mappedBy = "tender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegisteredGood> registeredGoodList = new ArrayList<>();

    // constructors, getters, and setters
}
