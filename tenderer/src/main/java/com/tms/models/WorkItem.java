package com.tms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name="work_item")
public class WorkItem {

    @Id
    @GeneratedValue(generator = "work_item_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "work_item_id_gen", sequenceName = "work_item_id_seq", allocationSize = 1)
    private Long id;
    private String itemCategory;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
