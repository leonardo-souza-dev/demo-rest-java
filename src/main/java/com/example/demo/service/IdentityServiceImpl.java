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
        return validarSenhaTamanho(senha) && validarSenhaNumeroObrigatorio(senha) && validarEmailProvedor(email);
    }

    private boolean validarSenhaTamanho(String senha) {
        return senha.length() >= 8;
    }
    
    private boolean validarSenhaNumeroObrigatorio(String senha) {
        return senha.matches(".*\\d+.*");
    }
    
    private boolean validarEmailProvedor(String email) {
        return email.contains("gmail");
    }
}
