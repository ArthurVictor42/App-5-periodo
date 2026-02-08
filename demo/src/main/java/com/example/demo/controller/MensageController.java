package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensage")
public class MensageController {

    @GetMapping
    public String mensage() {
        return "mensage";
    }
}
