package com.tms.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vender_invoice", schema = "public")
public class VenderInvoice {

    @Id
    private Long id;

}
