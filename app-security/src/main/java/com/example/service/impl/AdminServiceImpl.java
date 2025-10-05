package com.example.service.impl;

import com.example.model.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Secured({"ROLE_ADMIN"})
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

}
