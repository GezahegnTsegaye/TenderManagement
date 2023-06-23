package com.tms.security.auth;

import com.tms.model.user.Role;
import lombok.*;

@Data
@Builder@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
public class RegisterRequest {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Role role;



}
