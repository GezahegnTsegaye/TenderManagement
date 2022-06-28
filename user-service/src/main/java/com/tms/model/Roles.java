package com.tms.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "public")
public class Roles {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq")
    private Long id;
    private String role;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<Users> users;


    public Roles() {
    }

    public Roles(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
