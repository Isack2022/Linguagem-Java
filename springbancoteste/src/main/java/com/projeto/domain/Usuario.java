package com.projeto.domain;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Usuario {
	
	@Id
	@Column(nullable=false)
	private Long idusuario;
	@Column(nullable=false, unique=true)
	private String nomeusuario;
	@Column(nullable=false)
	private String senha;
	@Column(nullable=false)
	private String nivelacesso;
	
	public Usuario() {
		
	}

	public Usuario(Long idusuario, String nomeusuario, String senha, String nivelacesso) {
		super();
		this.idusuario = idusuario;
		this.nomeusuario = nomeusuario;
		this.senha = senha;
		this.nivelacesso = nivelacesso;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelacesso() {
		return nivelacesso;
	}

	public void setNivelacesso(String nivelacesso) {
		this.nivelacesso = nivelacesso;
	}
	
	
	
}
