package com.example.demo;

import java.math.BigDecimal;

public interface IProdutoRepository {
    Produto inserir(String nome, BigDecimal preco);
}
