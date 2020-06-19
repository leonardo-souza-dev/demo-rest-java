package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.Logger;
import com.example.demo.service.ProdutoServiceImpl;

import com.example.demo.controller.ProdutoController;
import com.example.demo.dto.ProdutoDto;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest
public class ProdutoTests {

    @Mock
    private ProdutoRepository repository;

    @Mock
    private Logger logger;

    @Test
    public void naoDeveInserirProdutoNaBaseSePrecoMaiorQue10000() throws Exception {
		
        // arrange
        String nome = "TV";
        BigDecimal preco = new BigDecimal(11000);

        ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);
        
        // act
        Produto produto = sut.inserirProduto(nome, preco);

        // assert
        assertNull(produto);
    }

    @Test
    public void deveInserirProduto() throws Exception {

        // arrange

        // act

        // assert
    }
}
