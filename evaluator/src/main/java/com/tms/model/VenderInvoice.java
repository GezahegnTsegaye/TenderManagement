package com.tms.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vender_invoice", schema = "public")
public class VenderInvoice {

    @Id
    private Long id;

}
