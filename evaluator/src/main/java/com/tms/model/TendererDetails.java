package com.tms.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@AllArgsConstructor@NoArgsConstructor@Getter
@Entity
@Table(name = "tenderer_detail")
public class TendererDetails {

    @Id
    @GeneratedValue(generator = "tenderer_detail_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tenderer_detail_id_gen", sequenceName = "tenderer_detail_id_seq", allocationSize = 1)
    private Long id;



}
