package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;

@Service
public class IdentityServiceImpl implements IdentityService {

    public Usuario cadastrarUsuario(String email, String senha){
        
        if (!validarDados(email, senha)) {
            return null;
        }

        //implementação de persistência aqui
        
        return new Usuario(email, senha);
    }

    private boolean validarDados(String email, String senha) {        
        return senha.length() >= 8 && email.contains("gmail");
    }
}
