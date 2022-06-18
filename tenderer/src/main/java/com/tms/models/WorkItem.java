package com.tms.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class WorkItem {

    @Id
    private Long id;
    private String itemCategory;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
