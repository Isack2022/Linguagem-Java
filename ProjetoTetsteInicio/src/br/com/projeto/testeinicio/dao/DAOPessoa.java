package br.com.projeto.testeinicio.dao;

import br.com.projeto.testeinicio.domain.Pessoa;

public class DAOPessoa {
	
	/**
	 * 
	 * @param pessoa
	 * @return Retorna uma de 2 frases: Os campos devem ser preenchidos ou Seus Dados foram registrados
	 */
	public static String registrar(Pessoa pessoa) {
		String msg = "";
		
		if(pessoa.getId() < 1 
				||pessoa.getNome().equals("") 
				||pessoa.getEmail().equals("")
				) {
			msg = "Os campos deve ser preenchidos";
		}else {
			msg = "Seus dados foram registrados";
		}
		
		return msg;
	}
	public Pessoa pessoaAtualizada(Pessoa pessoa) {
		Pessoa pe = pessoa;
		if(pe.getId()<1|| pe.getNome().equals("")|| pe.getNome().equals("")|| pe.getEmail().equals("")) {
			new Exception("Preencha todos os campos");
		}
		return pe;
	}
	
}
