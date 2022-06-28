package com.tms.service.impl;


import com.tms.model.Users;
import com.tms.repository.UsersRepository;
import com.tms.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {



    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<Users> findByRole(String role) {
        return usersRepository.findByRole(role);
    }

    @Override
    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }
    @Override
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users findByPhoneNumber(String phoneNumber) {
        return usersRepository.findByPhoneNumber(phoneNumber);
    }



}
