package com.tms.service;


import com.tms.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersService {

  UserDto createUser(UserDto userDetails);

  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

  UserDto getUserDetailsByEmail(String email);
}
