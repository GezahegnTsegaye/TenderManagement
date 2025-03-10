package com.egov.tendering.audit.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gezahegn Tsegaye
 */
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class Users implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "user_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_seq", allocationSize = 1)
    private Long id;


    @Column(name = "First_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number")
    private Integer mobileNumber;

    @Column(name = "phone_number")
    private Integer phoneNumber;


    private String status;

}
