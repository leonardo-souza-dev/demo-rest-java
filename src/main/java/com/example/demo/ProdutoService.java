package com.example.demo;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoService implements IProdutoService {

    private final IProdutoRepository repository;
    private final ILogger logger;

    public ProdutoService(IProdutoRepository repository, ILogger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    public Produto inserirProduto(String nome, BigDecimal preco) throws Exception {

        logger.Gravar("Serviço de produto iniciado");

        return repository.inserir(nome, preco);
    }
}
