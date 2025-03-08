package com.egov.tendering.user.event;


import com.egov.tendering.user.dal.model.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class UserCreatedEvent extends UserEvent {
    private String email;
    private UserRole role;
}