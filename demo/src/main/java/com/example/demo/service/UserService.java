package com.example.demo.service;

import com.example.demo.dto.UserRegistrerResquest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserReposity userReposity;

    public void login(UserRequest userRequest) {
        UserEntity user = userReposity.findByEmail(userRequest.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getPassword().equals(userRequest.password())) {
            throw new RuntimeException("Senha inválida");
        }
    }

    public void registrar(UserRegistrerResquest userRequest) {
        UserEntity user = new UserEntity(
                null,
                userRequest.name(),
                userRequest.email(),
                userRequest.password(),
                userRequest.cpf()
        );

        userReposity.save(user);
    }
}
