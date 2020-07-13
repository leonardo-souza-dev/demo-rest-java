package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import com.example.demo.model.Usuario;
import com.example.demo.service.IdentityServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IdentityTests {

    @Test
    public void naoDeveCadastrarUsuarioComSenhaCurta() {
		
        // arrange
        String email = "teste@gmail.com";
        String senha = "123";

        IdentityServiceImpl sut = new IdentityServiceImpl();
        
        // act
        Usuario usuario = sut.cadastrarUsuario(email, senha);

        // assert
        assertNull(usuario);
    }

    // @Test
    // public void naoDeveCadastrarQuandoDiferenteDeGmail() {
		
    //     // arrange
    //     String email = "teste@teste.com";
    //     String senha = "1";

    //     IdentityServiceImpl sut = new IdentityServiceImpl();
        
    //     // act
    //     Usuario usuario = sut.cadastrarUsuario(email, senha);

    //     // assert
    //     assertNull(usuario);
    // }
}