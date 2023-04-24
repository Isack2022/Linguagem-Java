package br.com.poo.solid.interfaces;

public class Produto {
	private int id;
	private int descricao;
	private double preco;
	
	public Produto() {
		super();
	}


	public Produto(int id, int descricao, double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco; 
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDescricao() {
		return descricao;
	}


	public void setDescricao(int descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
