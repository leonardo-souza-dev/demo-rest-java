package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Usuario;
import com.example.demo.service.IdentityServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IdentityTests2 {


    @ParameterizedTest
    @CsvSource({ "gmail@uol.com, 123456789012356", "teste@gmail.com, 12345678" })
    //@Test
    public void deveCadastrarQuandoGmailQuandoSenhaMaiorQue8(String email, String senha) {
		
        // arrange
        IdentityServiceImpl sut = new IdentityServiceImpl();
        
        // act
        Usuario usuario = sut.cadastrarUsuario(email, senha);

        // assert
        assertNotNull(usuario);
    }

    @ParameterizedTest
    @CsvSource({ "teste@uol.com, 123456789012356", "teste@gmail.com, 123" })
    //@Test
    public void naoDeveCadastrarQuandoDiferentDeGmailQuandoSenhaMenorQue8(String email, String senha) {
		
        // arrange
        IdentityServiceImpl sut = new IdentityServiceImpl();
        
        // act
        Usuario usuario = sut.cadastrarUsuario(email, senha);

        // assert
        assertNull(usuario);
    }
}
