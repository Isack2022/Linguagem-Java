package br.com.poo.objetos;

import br.com.poo.classes.Usuario;

public class CriarUsuario {

	public static void main(String[] args) {
		//Realizar a instância da classe Usuario para
		//gerar um objeto		

		Usuario user1 = new Usuario();
		user1.id = 1;
		user1.nomeUsuario = "vendedor";
		user1.senha = "123";
		user1.grupo = new String[]{"admin","users","vendedores"};
		user1.cadastrar();
		user1.listarUsuario();
	}

}
