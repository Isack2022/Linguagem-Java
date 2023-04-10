package br.com.poo.classes.heranca;

/*
 * A classe PessoaFisica herda as propriedades e m�todos da classe Pessoa.
 * Por isso usamos o comando extends(extender) da gerar a heran�a.
 */
public abstract class PessoaFisica extends Pessoa{
	private String nome;
	private String cpf;
	public PessoaFisica() {}
	public PessoaFisica(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
