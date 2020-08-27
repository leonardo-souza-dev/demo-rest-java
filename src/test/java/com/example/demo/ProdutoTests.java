package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.Logger;
import com.example.demo.service.ProdutoServiceImpl;

import com.example.demo.controller.ProdutoController;
import com.example.demo.dto.ProdutoDto;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

@SpringBootTest
public class ProdutoTests {

    /// eu espero conseguir gravar um produto no repositorio
    @Test
    public void Foo1() {
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void Foo2() {
    }

    /// eu devo conseguir inserir um produto e não depender do serviço de log
    @Test
    public void Foo3() {
        
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido
    @Test
    public void Foo4() {

    }
}
