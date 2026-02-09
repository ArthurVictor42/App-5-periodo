package com.example.demo.dto;

public record UserRegistrerResquest(String name,
                                    String email,
                                    String password,
                                    String cpf) {
}
