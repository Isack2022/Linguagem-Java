package br.com.poo.classes.heranca;

/*
 * A classe PessoKJuridica herda as propriedades e métodos da classe Pessoa.
 * Por isso usamos o comando extends(extender) da gerar a herança.
 */
public  class PessoaJuridica extends Pessoa{
	private String razaoSocial;
	private String cnpj;
	
	public PessoaJuridica() {}

	public PessoaJuridica(String razaoSocial, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	{
}
	 
}
