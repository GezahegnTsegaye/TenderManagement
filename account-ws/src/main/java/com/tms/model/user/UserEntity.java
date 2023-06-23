package com.tms.model.user;


import com.tms.model.token.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor@Builder
@Entity
@Table(name = "users")
@AllArgsConstructor
public class UserEntity implements UserDetails {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
  @SequenceGenerator(name = "user_gen", sequenceName = "user_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(nullable = false, length = 50)
  private String firstName;
  @Column(nullable = false, length = 50)
  private String lastName;
  @Column(nullable = false, length = 120, unique = true)
  private String email;
  @Column(nullable = false, unique = true)
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
