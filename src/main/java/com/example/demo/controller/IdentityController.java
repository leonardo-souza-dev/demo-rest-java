package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.service.*;

@RestController
public class IdentityController {

	private IdentityService service;

	public IdentityController(IdentityService service){
		this.service = service;
	}

	@GetMapping("/cadastrarUsuario")
	public UsuarioDto cadastrarUsuario(@RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha) {

		Usuario usuario = service.cadastrarUsuario(email, senha);

		return usuario != null ? new UsuarioDto(usuario.getEmail(), usuario.getSenha()) : null;
	}
}
