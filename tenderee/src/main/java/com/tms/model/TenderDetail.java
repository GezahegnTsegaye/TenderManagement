package com.tms.model;


import lombok.*;

import javax.persistence.*;

//@Data
//@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class TenderDetail {

    @Id
    private Long id;
    private String paymentMod;
    private String coverContent;
    private String documentDescription;
    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

}
