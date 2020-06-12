package com.example.demo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoRepository implements IProdutoRepository {

    public Produto inserir(String nome, BigDecimal preco){
        //rotina de persistência aqui
        return new Produto(nome, preco);
    }
}
