package com.projeto.spring.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.spring.SalaRepository;
import com.projeto.spring.curso.domain.Curso;
import com.projeto.spring.curso.domain.Sala;
 
@RestController
public class SalaController {
	
	@Autowired
	private SalaRepository sl;
	
	@GetMapping("/sala/listar")
	public List<Sala> listar(){
		return sl.findAll();
	}
	
	@PutMapping("/sala/atualizar/{id}")
	public String atualizar(@PathVariable Long id,@RequestBody Sala sala) {
		String msg = "";
		Optional<Sala> s = sl.findById(id);
		if(s.isPresent()) {
			sala.setIdsala(id);
			sl.save(sala);
			msg = "Sala atualizado";
		}
		else {
			msg = "Sala não encontrada";
		}
		return msg;
	}
	
	@PostMapping("/sala/cadastrar")
	public String cadastrar(@RequestBody Sala sala) {
		sl.save(sala);
		return "Sala Adiconada";
	}
	
	@DeleteMapping("/sala/apagar/{id}")
	public String apagar(@PathVariable Long id) {
		String msg = "";
		Optional<Sala> s = sl.findById(id);
		if(s.isPresent()) {
			sl.deleteById(id);
			msg = "Sala apagado do banco";
		}
		else {
			msg = "Sala não localizada no banco de dados";
		}
		return msg;
		
	}
}
