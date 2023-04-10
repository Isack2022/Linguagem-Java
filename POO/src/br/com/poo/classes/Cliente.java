package br.com.poo.classes;

import java.sql.Date;


//Comentário em linha(inline)
/*
 * Comentário em bloco(in block) de várias linhas
 * */
//A classe Cliente representa um novo cliente no sistema
public class Cliente {
	//Atributos da classe
	public int id;
	public String nome;
	public String cpf;
	public Date dataNascimento;
	public String email;
	public String telefone;
	
	
	public String cadastrar() {
		
		return "Cadastro do cliente "+ nome +" foi realizado com sucesso!";
	}
	public void apagar() {
		System.out.println("Cliente apagado");
	}
		
}
