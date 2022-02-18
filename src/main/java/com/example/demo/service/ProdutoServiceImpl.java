package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.demo.repository.*;
import com.example.demo.model.*;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final Logger logger;

    public ProdutoServiceImpl(ProdutoRepository repository, Logger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    public Produto inserirProduto(String nome, BigDecimal preco) throws Exception {

        logger.gravar("Serviço de produto iniciado");

        if (preco.compareTo(new BigDecimal(10000)) > 0) {

            logger.gravar("Preço fora da faixa permitida");
            return null;
        }

        Produto produtoExistente = repository.obter(nome);

        if (produtoExistente != null)
            return produtoExistente;

        Produto produtoInserido = repository.inserir(nome, preco);

        return produtoInserido;
    }
}
