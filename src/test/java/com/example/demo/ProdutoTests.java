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
import org.junit.jupiter.api.BeforeEach;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProdutoTests {

    // K.I.S.S.
    // Y.A.G.N.I.

    @Mock
    private Logger logger;
    
    @Mock
    private ProdutoRepository repository;
    
    /// eu espero conseguir gravar um produto no ProdutoRepositoryImpl
    @Test
    public void should_save_produto_on_produtoRepository() throws Exception {
        
        // Arrange
        ProdutoRepositoryImpl sut = new ProdutoRepositoryImpl();
        String nome = "PS5";
        BigDecimal preco = BigDecimal.valueOf(200);

        // Act 
        Produto createdProduct = sut.inserir(nome, preco);

        // Assert
        assertNotNull(createdProduct);
        assertEquals(nome, createdProduct.getNome());
        assertEquals(preco, createdProduct.getPreco());
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void shouldNotSaveProductsWithPriceAbove10000() throws Exception {

        // Arrange
        String nome = "PS5";
        BigDecimal preco = BigDecimal.valueOf(12000);
        Produto expected = new Produto(nome, preco);
        ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);
        
        when(repository.inserir(nome, preco)).thenReturn(expected);

        // Act
        Produto actual = sut.inserirProduto(nome, preco);
        
        // Assert
        assertNull(actual);
        verify(logger).gravar("Serviço de produto iniciado");
        verify(logger).gravar("Preço fora da faixa permitida");
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido no serviço
    @Test
    public void shouldSaveProductsWhenValidProductsAreGiven() throws Exception {

        // Arrange
        String nome = "PS5";
        BigDecimal preco = BigDecimal.valueOf(10000);
        Produto expected = new Produto(nome, preco);
        ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger);
        
        when(repository.inserir(nome, preco)).thenReturn(expected);

        // Act
        Produto actual = sut.inserirProduto(nome, preco);
        
        // Assert
        assertNotNull(actual);
        assertEquals(nome, actual.getNome());
        assertEquals(preco, actual.getPreco());
    }
}
