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
    private ProdutoRepository produtoRepository;
    @Mock
    private Logger logger;
    
    private ProdutoService produtoService;   
    

    /// eu espero conseguir inserir um produto no repositorio
    @Test
    public void inserirProdutoComSucesso() throws Exception{

        String nome = new String("TV");
        BigDecimal preco = new BigDecimal(1200);
        Produto produtoFake = new Produto(nome, preco);

        when(produtoRepository.inserir(nome, preco)).thenReturn(produtoFake);

        produtoService = new ProdutoServiceImpl(produtoRepository, logger);

        Produto produto = produtoService.inserirProduto(nome, preco);

        assertNotNull(produto);
        verify(produtoRepository).inserir(nome, preco);
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void inserirProdutoComFalha() throws Exception {
        
        String nome = new String("TV");
        BigDecimal preco = new BigDecimal(12000);
                
        produtoService = new ProdutoServiceImpl(produtoRepository, logger);

        Produto produto = produtoService.inserirProduto(nome, preco);

        assertNull(produto);
        verify(produtoRepository, Mockito.times(0)).inserir(nome, preco);

    }

    /// eu devo conseguir inserir um produto e não depender do serviço de log
    @Test
    public void inserirComSucessoSemDependenciaLog() throws Exception {

        String nome = new String("TV");
        BigDecimal preco = new BigDecimal(1200);
        Produto produtoFake = new Produto(nome, preco);

        when(produtoRepository.inserir(nome, preco)).thenReturn(produtoFake);

        produtoService = new ProdutoServiceImpl(produtoRepository, logger);

        Produto produto = produtoService.inserirProduto(nome, preco);

        assertNotNull(produto);
        verify(produtoRepository).inserir(nome, preco);
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido
    @Test
    public void garantirChamadaRepository() throws Exception {

        String nome = new String("TV");
        BigDecimal preco = new BigDecimal(1200);
        Produto produtoFake = new Produto(nome, preco);

        when(produtoRepository.inserir(nome, preco)).thenReturn(produtoFake);

        produtoService = new ProdutoServiceImpl(produtoRepository, logger);

        Produto produto = produtoService.inserirProduto(nome, preco);

        assertNotNull(produto);
        verify(produtoRepository, Mockito.times(1)).inserir(nome, preco);
    }
}
