package com.tms.service;


import com.tms.model.Users;

import java.util.List;

public interface UsersService {


    Users findByUsername(String username);

    List<Users> findAll();
}
