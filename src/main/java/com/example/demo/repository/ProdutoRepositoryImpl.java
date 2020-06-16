package com.example.demo.repository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import com.example.demo.model.*;

@Service
public class ProdutoRepositoryImpl implements ProdutoRepository {

    public Produto inserir(String nome, BigDecimal preco){
        //rotina de persistência aqui
        return new Produto(nome, preco);
    }
}
