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
    ProdutoRepository repository;

    @Mock
    Logger logger;

    // K.I.S.S.
    // Y.A.G.N.I.

    /// eu espero conseguir gravar um produto no ProdutoRepositoryImpl
    @Test
    public void deveConseguirInserirUmProduto() throws Exception {
        //Arrange
        String nome = "Computador";
        BigDecimal preco = new BigDecimal(1000);
        ProdutoRepositoryImpl sut = new ProdutoRepositoryImpl(); 

        //act
        Produto computador = sut.inserir(nome, preco);

        //assert
        assertNotNull(computador);
    }

    /// eu não devo conseguir inserir um produto quando o preço for maior que 10000
    @Test
    public void naoDeveInserirProdutoPrecoMaior10000() throws Exception {
        
        //Arrange
        String nome = "Computador";
        BigDecimal preco = new BigDecimal(500);
        ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger); 

        //act
        Produto computador = sut.inserirProduto(nome, preco);

        //assert
        assertNull(computador);
    }

    /// eu preciso saber se o repositório é chamado ao salvar um produto válido no serviço
    @Test
    public void deveChamarORepositoryAoSalvarUmProdutoValido() throws Exception {
        
        // Arrange
        String nome = "Computador";
        BigDecimal preco = new BigDecimal(4000);

        ProdutoServiceImpl sut = new ProdutoServiceImpl(repository, logger); 

        // Act
        Produto computador = sut.inserirProduto(nome, preco);

        // Assert
        Mockito.verify(repository).inserir(nome, preco);
    }
}
