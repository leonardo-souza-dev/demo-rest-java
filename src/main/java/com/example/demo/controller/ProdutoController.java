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

	private final ProdutoService service;

	public ProdutoController(final ProdutoService service){
		this.service = service;
	}

	@GetMapping("/inserirProduto")
	public ProdutoDto inserirProduto(@RequestParam(value = "nome") final String nome, @RequestParam(value = "preco") final BigDecimal preco) throws Exception {

		ProdutoDto response;
		try {
			Produto produto = service.inserirProduto(nome, preco);

			if (produto == null) {
				response = new ProdutoDto(false, "Ocorreu um erro ao inserir o produto");
			} 
			else {
			response = new ProdutoDto(
				produto,
				true,
				"Produto inserido com sucesso");
			}
		}
		catch (final Exception ex){
			response = new ProdutoDto(
				false,
				"Ocorreu um erro ao inserir o produto");
		}
		return response;
	}
}
