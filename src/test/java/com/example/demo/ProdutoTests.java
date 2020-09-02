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

    // K.I.S.S.
    @Mock
    private Logger logger;
    @Mock
    private ProdutoRepository produtoRepository;
    /// eu espero conseguir gravar um produto no ProdutoRepositoryImpl
    @Test
    public void Foo1() throws Exception {
        // arrange
        String nomeProduto = "PS5";
        BigDecimal preco = new BigDecimal(10);

        // act
        ProdutoRepositoryImpl sut = new ProdutoRepositoryImpl();
        Produto produto = sut.inserir(nomeProduto, preco);

        // assert
        assertNotNull(produto);
        assertEquals(produto.getNome(), nomeProduto);
        assertEquals(produto.getPreco(), preco);
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void naoDeveInserirProdutoSePrecoMaior10000() throws Exception {
        // arrange
        String nomeProduto = "PS5";
        BigDecimal preco = new BigDecimal(10005);

        ProdutoServiceImpl sut = new ProdutoServiceImpl(produtoRepository, logger);

        //act
        Produto produto = sut.inserirProduto(nomeProduto, preco);

        //assert 
        assertNull(produto);
        verify(logger).gravar("Preço fora da faixa permitida");
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido no serviço
    @Test
    public void deveChamarRepositorioAoSalvarUmProdutoValidoNoServico() throws Exception {
        // arrange
        String nome = "TV";
        BigDecimal preco = new BigDecimal(7000);
        ProdutoServiceImpl sut = new ProdutoServiceImpl(produtoRepository, logger);

        when(produtoRepository.inserir(nome, preco)).thenReturn(new Produto(nome, preco));

        //act
        Produto produto = sut.inserirProduto(nome, preco);

        //assert
        assertNotNull(produto);
        verify(produtoRepository).inserir(nome, preco);
    }
}
