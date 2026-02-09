package com.example.demo.controller;

import com.example.demo.dto.UserRegistrerResquest;
import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private ResponseEntity<Void> Login(@RequestBody UserRequest userRequest) {
        userService.login(userRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/registrar")
    private ResponseEntity<Void> Cadastrar(@RequestBody UserRegistrerResquest userRequest) {
        userService.registrar(userRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
