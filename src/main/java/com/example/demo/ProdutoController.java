package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProdutoController {

	private IProdutoService service;

	public ProdutoController(IProdutoService service){
		this.service = service;
	}

	@GetMapping("/inserirProduto")
	public ProdutoResponse inserirProduto(@RequestParam(value = "nome") String nome, @RequestParam(value = "preco") BigDecimal preco) throws Exception {

		ProdutoResponse response;
		try {
			Produto produto = service.inserirProduto(nome, preco);
			response = new ProdutoResponse(
				produto,
				true,
				"Produto inserido com sucesso");}
		catch (Exception ex){
			response = new ProdutoResponse(
				false,
				"Ocorreu um erro ao inserir o produto");
		}
		return response;
	}
}
