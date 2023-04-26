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

import com.projeto.spring.TurmaRepository;
import com.projeto.spring.curso.domain.Curso;
import com.projeto.spring.curso.domain.Turma;

@RestController
public class TurmaController {
	
	@Autowired
	private TurmaRepository tm;
	
	@GetMapping("/turma/listar")
	public List<Turma> listar(){
		return tm.findAll();
	}
	@GetMapping("/turma/listar/{id}")
	public Optional<Turma> listar(@PathVariable Long id) {
		return tm.findById(id);
	}
	
	@PostMapping("/turma/cadastrar")
	public String cadastrar(@RequestBody Turma turma) {
	
		tm.save(turma);
		return "Cadastrou"; 
	}  
	
	@PutMapping("/turma/atualizar/{id}")
	public String atualizar(@PathVariable Long id,@RequestBody Turma turma) {
		String msg = "";
		Optional<Turma> t = tm.findById(id);
		
		if(t.isPresent()) {
			turma.setIdcurso(id);
			tm.save(turma);
			msg = "Turma atualizado";
		}
		else {
			msg = "Turma não encontrada";
		}
		return msg;
	}
	@DeleteMapping("/turma/apagar/{id}")
	public String apagar(@PathVariable Long id) {
		String msg = "";
		Optional<Turma> t = tm.findById(id);
		
		if(t.isPresent()) {
			tm.deleteById(id);
			msg = "Turma apagada";
		}
		else {
			msg = "Turma não localizada no banco de dados";
		}
		return msg;
		
	}
}
