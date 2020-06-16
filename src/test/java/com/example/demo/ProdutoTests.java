package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import com.example.demo.controller.ProdutoController;
import com.example.demo.dto.ProdutoDto;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoTests {

    @Test
    public void deveInserirProduto() throws Exception {
		
        // arrange
        String nomeProduto = "TV";
        BigDecimal preco = new BigDecimal(3999);

        ProdutoRepositoryImpl repository = new ProdutoRepositoryImpl();
        LoggerImpl logger = new LoggerImpl();
        ProdutoServiceImpl service = new ProdutoServiceImpl(repository, logger);
        
        ProdutoController sut = new ProdutoController(service);

        // act
        ProdutoDto response = sut.inserirProduto(nomeProduto, preco);

        // assert
        assertNotNull(response);
        assertNotNull(response.getProduto());
        assertEquals(nomeProduto, response.getProduto().getNome());
        assertEquals(preco, response.getProduto().getPreco());
        assertTrue(response.getSucesso());
        assertEquals("Produto inserido com sucesso", response.getMensagem());
    }
}
