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
        
    }
}
