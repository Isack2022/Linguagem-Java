package br.com.projeto.testeinicio.dao.teste;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.projeto.testeinicio.dao.DAOPessoa;
import br.com.projeto.testeinicio.domain.Pessoa;


public class TesteDAOPessoa {
	
	@Test
	public void testeRegistrar() {
		DAOPessoa dp = new DAOPessoa();
		
		Pessoa pe = new Pessoa();
		pe.setId(20);
		pe.setNome("Márcia");
		pe.setEmail("marciasouza@yahoo.com.br");
		
		String rs = dp.registrar(pe);
		
		Assertions.assertEquals("Seus dados foram registrados",rs);
		
	}

	@Test
	public void testPessoaAtualizada() {
		DAOPessoa dp = new DAOPessoa();
		
		Pessoa pe =  new Pessoa(10,"Claúdio","claudiosilva@uol.com.br");
		String rs = dp.registrar(pe);
		
		System.out.println(pe.getNome());
		pe.setNome("Márcia");
		Pessoa rsp = dp.pessoaAtualizada(pe);
		
		Assertions.assertEquals("Márcia", rsp.getNome());
	}
}
