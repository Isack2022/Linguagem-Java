package br.com.poo.classes;

public class Produto {
	private int id;
	private String nome;
	private double preco;
	private int quantidade;
	private Categoria categoria;
	private Fornecedor fornecedor;
	
	//Vamos criar um método construtor. Este método é
	//executado todas as vezes que uma classe é instânciada
	public Produto(int id, String nome, double preco, int quantidade, Categoria categoria, Fornecedor fornecedor) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
	}
	
	public Produto() {}
	
	public void cadastrar() {
		System.out.println("Produto cadastrado");
	}
	public void listar() {
		System.out.println(
				"\nId do Produto:"+id+
				"\nNome:"+nome+
				"\nPreço:"+preco+
				"\nQuantidade:"+quantidade+
				"\nCategoria:"+categoria.titulo+
				"\nFornecedor:"+fornecedor.nomeFantasia
				);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
