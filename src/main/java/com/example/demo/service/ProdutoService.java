package com.example.demo.service;

import com.example.demo.model.*;

import java.math.BigDecimal;

public interface ProdutoService {
    Produto inserirProduto(String nome, BigDecimal preco) throws Exception;
}
