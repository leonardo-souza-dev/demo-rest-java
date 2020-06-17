package com.example.demo.dto;

public class UsuarioDto {

    private String email;
    private String senha;

    public UsuarioDto(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }    
}
