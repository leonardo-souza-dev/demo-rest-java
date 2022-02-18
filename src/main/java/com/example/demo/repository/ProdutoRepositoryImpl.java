package com.example.demo.repository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;

@Service
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();

    public ProdutoRepositoryImpl() {
        produtos.add(new Produto("Micro-ondas", BigDecimal.valueOf(500)));
    }

    public Produto inserir(String nome, BigDecimal preco){
        
        //rotina de banco aqui
        Produto produto = new Produto(nome, preco);

        return produto;
    }

    public Produto obter(String nome){
        
        //rotina de banco aqui
        Produto produto = produtos.stream().filter(p -> p.getNome() == nome).findFirst().get();

        return produto;
    }
}
