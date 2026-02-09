package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserResponse;

@Service
public class UserService {

    @Autowired
    private UserReposity userReposity;

    public void login(UserRequest userRequest) {

    }


    public void registrar(UserRequest userRequest) {

    }
}
