package br.com.poo.objetos;

import br.com.poo.classes.Produto;

public class CriarProduto {

	public static void main(String[] args) {
		
		Produto prod = new Produto();		
		prod.cadastrar();
		prod.listar();
	}

}
