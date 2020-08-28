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
    ProdutoRepository produtoRepository;

    @Mock
    Logger logger;

    /// eu espero conseguir gravar um produto no ProdutoRepositoryImpl
    @Test
    public void Foo1() throws Exception {
        String nome = "TV";
        BigDecimal preco = new BigDecimal(200);

        ProdutoRepositoryImpl produtoRepository = new ProdutoRepositoryImpl();

        Produto produto = produtoRepository.inserir(nome, preco);

        assertEquals("TV", produto.getNome());
        assertEquals(new BigDecimal(200), produto.getPreco());
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void Foo2() throws Exception {        
        String nome = "TV";
        BigDecimal preco = new BigDecimal(10001);

        ProdutoServiceImpl produtoServiceImpl = new ProdutoServiceImpl(produtoRepository, logger);
        Produto produto = produtoServiceImpl.inserirProduto(nome, preco);
        
        assertNull(produto);
    }

    /// eu devo conseguir inserir um produto e não depender do serviço de log
    @Test
    public void Foo3() throws Exception {
        String nome = "TV";
        BigDecimal preco = new BigDecimal(10001);

        ProdutoServiceImpl produtoServiceImpl = new ProdutoServiceImpl(produtoRepository, logger);
        Produto produto = produtoServiceImpl.inserirProduto(nome, preco);
        
        assertNull(produto);
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido
    @Test
    public void Foo4() throws Exception {

        String nome = "TV";
        BigDecimal preco = new BigDecimal(999);

        ProdutoServiceImpl produtoServiceImpl = new ProdutoServiceImpl(produtoRepository, logger);
        produtoServiceImpl.inserirProduto(nome, preco);
        
        verify(produtoRepository).inserir(nome, preco);

    }
}
