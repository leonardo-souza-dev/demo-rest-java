package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import com.example.demo.*;

@RestController
public class IdentityController {

	// private UsuarioService service;

	// public IdentityController(UsuarioService service){
	// 	this.service = service;
	// }

	// @GetMapping("/inserirUsuario")
	// public ProdutoResponse inserirUsuario(@RequestParam(value = "nome") String nome, @RequestParam(value = "preco") BigDecimal preco) throws Exception {

	// 	ProdutoResponse response;
	// 	try {
	// 		Produto produto = service.inserirProduto(nome, preco);
	// 		response = new ProdutoResponse(
	// 			produto,
	// 			true,
	// 			"Produto inserido com sucesso");}
	// 	catch (Exception ex){
	// 		response = new ProdutoResponse(
	// 			false,
	// 			"Ocorreu um erro ao inserir o produto");
	// 	}
	// 	return response;
	// }
}
