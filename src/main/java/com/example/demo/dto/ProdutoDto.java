package com.example.demo.dto;

import com.example.demo.model.*;

public class ProdutoDto {

    private Produto produto;
    private final Boolean sucesso;
    private final String mensagem;

    public ProdutoDto(final Produto produto, final Boolean sucesso, final String mensagem) {
        this.produto = produto;
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public ProdutoDto(final Boolean sucesso, final String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public Produto getProduto() {
         return produto;
    }

    public boolean getSucesso(){
        return sucesso;
    }

    public String getMensagem(){
        return mensagem;
    }
}
