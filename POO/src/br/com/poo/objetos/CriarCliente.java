package br.com.poo.objetos;

import java.sql.Date;

import br.com.poo.classes.Cliente;

public class CriarCliente {

	public static void main(String[] args) {
	
		//Para criar um objeto iremos fazer a instância da classe Cliente
		Cliente cliente1 = new Cliente();
		//passar as propriedades para o cliente
		cliente1.id = 1;
		cliente1.nome = "Vanessa Oliveira";
		cliente1.cpf = "545454845";
		cliente1.email = "vanessa@uol.com.br";
		cliente1.telefone = "(11) 5565-4588";
		cliente1.dataNascimento = Date.valueOf("2023-03-13");
		
		//Vamos cadastrar o cliente acima com o comando cadastrar
		System.out.println(cliente1.cadastrar());
		

	}

}
