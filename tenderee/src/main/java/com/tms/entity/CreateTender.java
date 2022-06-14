package com.tms.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tender", schema = "public")
public class CreateTender implements Serializable {

    @Id
    private long id;

    private String tender_name;
    private String tender_description;
    private String tender_startDate;
    private String tender_endDate;
    private String tender_status;
    private String tender_createdBy;
    private String tender_createdDate;
    private String tender_updatedBy;
    private String tender_updatedDate;
    private String tender_deletedBy;
    private String tender_deletedDate;
    private String tender_type;
    private String tender_category;
    private String tender_subCategory;


}
