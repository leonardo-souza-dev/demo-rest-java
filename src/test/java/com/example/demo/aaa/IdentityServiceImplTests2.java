package com.example.demo.aaa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import com.example.demo.model.Usuario;
import com.example.demo.service.IdentityServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IdentityServiceImplTests2 {

    @Test
    public void quandoSenhaValida_deveCadastrarUsuario() {
		
        // arrange
        String email = "teste@gmail.com";
        String senha = "asdfghj1";

        IdentityServiceImpl sut = new IdentityServiceImpl();
        
        // act
        Usuario usuario = sut.cadastrarUsuario(email, senha);

        // assert
        assertNotNull(usuario);
    }

    @Test
    public void quandoSenhaCurta_naoDeveCadastrarUsuario() {
		
        // arrange
        String email = "teste@gmail.com";
        String senha = "123";

        IdentityServiceImpl sut = new IdentityServiceImpl();
        
        // act
        Usuario usuario = sut.cadastrarUsuario(email, senha);

        // assert
        assertNull(usuario);
    }
}
