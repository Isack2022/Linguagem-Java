package br.com.poo.classes;

public class UsarEmpregado {

	public static void main(String[] args) {
		Empregado fagner = new Empregado();
		System.out.println(fagner.salvar());
		fagner.mensagem("Olá Fagner");
		
		Setor vendas = new Setor();
		System.out.println(vendas.salvar());
		vendas.mensagem("Novo setor para a empresa");

	}

}
