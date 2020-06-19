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

    @Mock
    private ProdutoRepository repository;

    @Mock
    private Logger logger;

    @Mock
    private ProdutoService produtoService;

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
    public void deveLogarQuandoPrecoForaDaFaixa() throws Exception {

        // arrange
        ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);

        // act
        Produto produtoDto = sut.inserirProduto("TV", new BigDecimal(11000));

        // assert
        verify(logger).gravar("Preço fora da faixa permitida");;
    }

    @Test
    public void deveRetornarMensagemCorretaAoInserirProduto() throws Exception {

        // arrange
        String nomeProduto = "TV";
        BigDecimal preco = new BigDecimal(2000);
        Produto produto = new Produto(nomeProduto, preco);

        when(produtoService.inserirProduto(nomeProduto, preco)).thenReturn(produto);

        ProdutoController sut = new ProdutoController(produtoService);

        // act
        ProdutoDto produtoDto = sut.inserirProduto(nomeProduto, preco);

        // assert
        assertNotNull(produtoDto);
        assertEquals("Produto inserido com sucesso", produtoDto.getMensagem());
    }

    @Test
    public void deveInserirProduto() throws Exception {

        // arrange

        // act

        // assert
    }
}
