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

    @Mock
    ProdutoService produtoService;

    @Test
    public void naoDeveInserirProdutoNaBaseSePrecoMaiorQue10000() throws Exception {
        
    }

    @Test
    public void deveLogarQuandoPrecoForaDaFaixa() throws Exception {
     
    }

    @Test
    public void deveRetornarMensagemCorretaAoInserirProdutoNaController() throws Exception {

    }
}
