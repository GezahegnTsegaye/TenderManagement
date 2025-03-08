package com.egov.tendering.user.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
//
//@Setter@Getter@NoArgsConstructor@AllArgsConstructor
//@Entity
//@Table(name = "roles")
//public class Roles {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq")
//    private Long id;
//    private String role;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> users;
//
//
//    @Override
//    public String toString() {
//        return "Roles{" +
//                "id=" + id +
//                ", role='" + role + '\'' +
//                '}';
//    }
//}
