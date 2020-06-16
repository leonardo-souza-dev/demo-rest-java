package com.example.demo.repository;

import java.math.BigDecimal;

import com.example.demo.model.*;

public interface ProdutoRepository {
    Produto inserir(String nome, BigDecimal preco);
}
