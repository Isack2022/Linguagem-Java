package br.com.poo.classes.heranca;
/*
 * A classe Cliente herda as propriedades e métodos da classe PessoaFisica.
 * Por isso usamos o comando extends(extender) da gerar a herança.
 */
public class Cliente extends PessoaFisica{
	private double saldoCompras;

	public Cliente() {}

	public Cliente(double saldoCompras) {
		this.saldoCompras = saldoCompras;
	}

	
	public double getSaldoCompras() {
		return saldoCompras;
	}

	public void setSaldoCompras(double saldoCompras) {
		this.saldoCompras = saldoCompras;
	}
	
}
 