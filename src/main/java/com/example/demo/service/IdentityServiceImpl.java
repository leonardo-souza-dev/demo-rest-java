package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;

@Service
public class IdentityServiceImpl implements IdentityService {

    public Usuario cadastrarUsuario(String email, String senha){
        
        if (!validarDados1(senha)) {
            return null;
        }

        //implementação de persistência aqui
        
        return new Usuario(email, senha);
    }

    private boolean validarDados1(String senha) {        
        if (senha.length() > 8)
            return true;        
        return false;
    }

    // private boolean validarDados2(String senha, String email) {        
    //     if (senha.length() > 8 && email.contains("gmail"))
    //         return true;        
    //     return false;
    // }
}
