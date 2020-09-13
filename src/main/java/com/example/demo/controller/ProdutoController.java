package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import com.example.demo.service.*;
import com.example.demo.model.*;
import com.example.demo.dto.*;

@RestController
public class ProdutoController {

	private ProdutoService service;

	public ProdutoController(ProdutoService service){
		this.service = service;
	}

	@GetMapping("/inserirProduto")
	public ProdutoDto inserirProduto(@RequestParam(value = "nome") String nome, @RequestParam(value = "preco") BigDecimal preco) throws Exception {

		Produto produto = service.inserirProduto(nome, preco);
		
		if (produto == null) {
			return new ProdutoDto(produto, true, "Produto inserido com sucesso");
		} 
		else {
			return new ProdutoDto(false, "Ocorreu um erro ao inserir o produto");
		}
	}
}
