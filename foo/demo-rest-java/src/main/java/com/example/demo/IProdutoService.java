package com.example.demo;

import java.math.BigDecimal;

public interface IProdutoService {
    Produto inserirProduto(String nome, BigDecimal preco) throws Exception;
}
