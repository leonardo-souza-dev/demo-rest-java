package com.example.demo.aaa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import com.example.demo.model.Usuario;
import com.example.demo.service.IdentityServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IdentityServiceImplTests {

    @Test
    public void quandoSenhaValida_deveCadastrarUsuario() {
		
        // arrange
        
        // act

        // assert
    }

    @Test
    public void quandoSenhaCurta_naoDeveCadastrarUsuario() {
    }
}
