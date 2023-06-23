package com.tms.model.token;

import com.tms.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token_entity")
public class Token {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_entity_gen")
  @SequenceGenerator(name = "token_entity_gen", sequenceName = "token_entity_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(unique = true)
  private String token;

  @Enumerated(EnumType.STRING)
  private TokenType tokenType = TokenType.BEARER;

  private boolean revoked;
  private boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userId")
  private UserEntity user;

}
