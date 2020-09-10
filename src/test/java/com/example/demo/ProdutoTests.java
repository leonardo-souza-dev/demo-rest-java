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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.math.BigDecimal;

@SpringBootTest
public class ProdutoTests {

    // K.I.S.S.
    // Y.A.G.N.I

    // repositorio vai aqui, anotado com 
    @Mock 
    private ProdutoRepository repository;
    
    @Mock 
    private Logger logger;

    /// eu espero conseguir gravar um produto no ProdutoServiceImpl
    @Test
    public void test_gravar_produto_com_sucesso() throws Exception {
        
        // arrange
            String nome = "PC MASTER RACER";
            BigDecimal preco = new BigDecimal(9999);
            Produto retorno = new Produto(nome, preco);
            ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);
            when(repository.inserir(nome, preco)).thenReturn(retorno);
        // act
           Produto produto = sut.inserirProduto(nome, preco);
        // assert           
           assertNotNull(produto);
           verify(repository).inserir(nome, preco);
           assertEquals(retorno.getNome(), produto.getNome());
           assertEquals(retorno.getPreco(), produto.getPreco());
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void test_inserir_produto_preco_too_big() throws Exception {
        
         // arrange
            
            String nome = "PC MASTER RACER";
            BigDecimal preco = new BigDecimal(11000);
            Produto retorno = new Produto(nome, preco);
            ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);
            when(repository.inserir(nome, preco)).thenReturn(retorno);
        
        // act
           
           Produto produto = sut.inserirProduto(nome, preco);
        
        // assert           
           
           assertNull(produto);
           //logger.gravar("Preço fora da faixa permitida");
           verify(logger).gravar("Preço fora da faixa permitida");  
           verify(repository, Mockito.never()).inserir(nome, preco); 
        
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido no serviço
    @Test
    public void test_salvar_produto_valido_servicoo() throws Exception {
        
         // arrange
            
            String nome = "PC MASTER RACER";
            BigDecimal preco = new BigDecimal(9999);
            Produto retorno = new Produto(nome, preco);
            ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);
            when(repository.inserir(nome, preco)).thenReturn(retorno);
        
        // act
           
           Produto produto = sut.inserirProduto(nome, preco);
        
        // assert           
           assertNotNull(produto);
           verify(repository).inserir(nome, preco);
           assertEquals(retorno.getNome(), produto.getNome());
           assertEquals(retorno.getPreco(), produto.getPreco());
        
    }
}
