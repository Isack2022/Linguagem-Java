package com.projeto.spring.curso.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long idsala;
	
	@Column(nullable=false) 
	private int numero;
	
	@Column(nullable=false)
	private String tipo;
	
	@Column(nullable=false)
	private String descricao;


	public Sala() {
	}

	public Sala(Long idsala, int numero, String tipo, String descricao) {
		super();
		this.idsala = idsala;
		this.numero = numero;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Long getIdsala() {
		return idsala;
	}

	public void setIdsala(Long idsala) {
		this.idsala = idsala;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
