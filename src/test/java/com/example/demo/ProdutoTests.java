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
    ProdutoRepositoryImpl produtoRepository;

    @Mock
    Logger logger;
    /// eu espero conseguir inserir um produto no repositorio
    @Test
    public void inserindoProdutoNoRepositorio() {
        
        //arrange
        ProdutoServiceImpl sut = new ProdutoServiceImpl(produtoRepository, logger);

        String nomeProduto = "Notebook";
        BigDecimal valor = new BigDecimal(2000);
        Produto produto = new Produto(nomeProduto,valor);

        when(produtoRepository.inserir(nomeProduto, valor)).thenReturn(produto);

        //act
        Produto retorno = sut.inserirProduto(nomeProduto,valor);
        //assert
        assertNotNull(retorno);
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void produtoNaoPodeSerInserioComValorMaiorQue1000() {
         //arrange
        ProdutoServiceImpl sut = new ProdutoServiceImpl(produtoRepository, logger);

        String nomeProduto = "Notebook";
        BigDecimal valor = new BigDecimal(11000);
        Produto produto = new Produto(nomeProduto,valor);
        when(produtoRepository.inserir(nomeProduto, valor)).thenReturn(produto);

       //act
        Produto retorno = sut.inserirProduto(nomeProduto,valor);

        //assert
        assertNull(retorno);
    }

    /// eu devo conseguir inserir um produto e não depender do serviço de log
    @Test
    public void inserirProdutoSemDependerDoServicoDeLogger() {
        //arrange
        ProdutoServiceImpl sut = new ProdutoServiceImpl(produtoRepository, logger);

        String nomeProduto = "Notebook";
        BigDecimal valor = new BigDecimal(2000);
        Produto produto = new Produto(nomeProduto,valor);

        //act
        when(produtoRepository.inserir(nomeProduto, valor)).thenReturn(produto);
        
        Produto retorno = sut.inserirProduto(nomeProduto,valor);

        //assert
        assertNotNull(retorno);
        
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido
    @Test
    public void Foo4() {

    }
}
