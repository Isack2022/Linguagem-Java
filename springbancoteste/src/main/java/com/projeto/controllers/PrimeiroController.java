package com.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.domain.Usuario;
import com.projeto.repository.UsuarioRepository;

@RestController
public class PrimeiroController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/projeto/banco")
	public String msg() {
		return "Olá! O sistema está online";
	}
	
	@PostMapping("/projeto/banco/cadastrar")
	public String cadatro(@RequestBody Usuario dados) {
		String msg = "Cadastro com sucesso!";
		
		Usuario nome = ur.save(dados);
		
		return msg +""+nome.getNomeusuario();
	}
}
