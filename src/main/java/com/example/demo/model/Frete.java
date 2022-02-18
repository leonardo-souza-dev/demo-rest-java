package com.example.demo.model;

public class Frete {

    private final String cep;

    public Frete(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public int getValor() {
        return cep.startsWith("0") ? 5  : 10;
    }

    public int ObterPrazo() {
        return cep.startsWith("0") ? 3 : 5;
    }
}
