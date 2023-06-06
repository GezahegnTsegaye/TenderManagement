package com.tms.service.impl;


import com.tms.model.Users;
import com.tms.repository.UsersRepository;
import com.tms.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {



    private final UsersRepository usersRepository;

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }



    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }




}
