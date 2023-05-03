package com.tms.model;


<<<<<<< HEAD
import jakarta.persistence.*;
=======
>>>>>>> a35bd8f118291efa471cca98736c83735285c780
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
=======
import javax.persistence.*;
import java.io.Serializable;
>>>>>>> a35bd8f118291efa471cca98736c83735285c780
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
<<<<<<< HEAD
@Table(name = "users")
public class Users {
=======
@Table(name = "users", schema = "public")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
>>>>>>> a35bd8f118291efa471cca98736c83735285c780

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
<<<<<<< HEAD
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
=======
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
>>>>>>> a35bd8f118291efa471cca98736c83735285c780
    private List<Roles> roles;
}
