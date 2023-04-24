package com.projeto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@GetMapping("/projeto/banco")
	public String msg() {
		return "Olá! O sistema está online";
	}
	
	@PostMapping("/projeto/banco/cadastrar")
	public String cadatro(@RequestBody String dados) {
		String msg = "Cadastro com sucesso!";
		System.out.println(dados);
		return msg;
	}
}
