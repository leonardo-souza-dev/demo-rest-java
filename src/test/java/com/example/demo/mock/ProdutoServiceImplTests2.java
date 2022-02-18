package com.example.demo.mock;

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
public class ProdutoServiceImplTests2 {

    @Mock
    private ProdutoRepository repositoryMock;

    @Mock
    private Logger logger;

    // EXERCICIO simples
    @Test
    public void quandoPrecoMaiorQue10000_entaoNaoDeveInserirProdutoNaBase() throws Exception {
		
        // arrange
        String nome = "TV";
        BigDecimal preco = new BigDecimal(11000);

        ProdutoServiceImpl sut = new ProdutoServiceImpl(repositoryMock, logger);
        
        // act
        Produto produto = sut.inserirProduto(nome, preco);

        // assert
        assertNull(produto);
    }

    // EXERCICIO when thenReturn
    @Test
    public void quandoPrecoValido_entaoNeveInserirProdutoNaBase() throws Exception {
		
        // arrange
        String nome = "TV";
        BigDecimal preco = new BigDecimal(5000);

        Produto produto = new Produto(nome, preco);
        when(repositoryMock.inserir(nome, preco)).thenReturn(produto);

        ProdutoServiceImpl sut = new ProdutoServiceImpl(repositoryMock, logger);
        
        // act
        Produto actual = sut.inserirProduto(nome, preco);

        // assert
        assertNotNull(actual);
        assertEquals(nome, actual.getNome());
        assertEquals(preco, actual.getPreco());
    }

    // DEMONSTRACAO VERIFY
    @Test
    public void quandoPrecoForaDaFaixa_entaoDeveLogar() throws Exception {

        // arrange
        ProdutoServiceImpl sut = new ProdutoServiceImpl(repositoryMock, logger);

        // act
        Produto produtoDto = sut.inserirProduto("TV", new BigDecimal(11000));

        // assert
        verify(logger).gravar("Preço fora da faixa permitida");;
    }
}
