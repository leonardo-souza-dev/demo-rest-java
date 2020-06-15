package com.example.demo;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Produto produto;
    private boolean sucesso;
    private String mensagem;

    public ProdutoResponse(Produto produto,
                           boolean sucesso,
                           String mensagem) {
        this.produto = produto;
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public ProdutoResponse(boolean sucesso, String mensagem){
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
