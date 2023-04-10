package br.com.poo.classes.heranca;

public abstract class ContaBancaria {
	private Long numeroBanco;
	private int agencia;
	private long numeroConta;
	private String titular;
	private double saldo;
	
	public String verificarSaldo() {
		return "Seu saldo é "+saldo;
	}
	
	public String depositar(double valor) {
		saldo += valor;
		return "Depósito efetuado";
	}
	
	public String sacar(double valor) {
		saldo -= valor;
		return"saque realizado";
	}

	
	public Long getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(Long numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
