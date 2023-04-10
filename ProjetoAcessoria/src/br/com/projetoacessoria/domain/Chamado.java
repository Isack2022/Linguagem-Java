package br.com.projetoacessoria.domain;

import java.sql.Date;

public class Chamado {
	private Long idChamado;
	private String solicitacao;
	private String depSolicitado;
	private String descChamado;
	private Date dataAbertura;
	private Date dataResolucao;
	private String statusChamado;
	private String observacoes;
	private String atendente;
	
	public Chamado() {}

	public Chamado(Long idChamado, String solicitacao, String depSolicitado, String descChamado, Date dataAbertura,
			Date dataResolucao, String statusChamado, String observacoes, String atendente) {
		this.idChamado = idChamado;
		this.solicitacao = solicitacao;
		this.depSolicitado = depSolicitado;
		this.descChamado = descChamado;
		this.dataAbertura = dataAbertura;
		this.dataResolucao = dataResolucao;
		this.statusChamado = statusChamado;
		this.observacoes = observacoes;
		this.atendente = atendente;
	}

	public Long getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Long idChamado) {
		this.idChamado = idChamado;
	}

	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getDepSolicitado() {
		return depSolicitado;
	}

	public void setDepSolicitado(String depSolicitado) {
		this.depSolicitado = depSolicitado;
	}

	public String getDescChamado() {
		return descChamado;
	}

	public void setDescChamado(String descChamado) {
		this.descChamado = descChamado;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(Date dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public String getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(String statusChamado) {
		this.statusChamado = statusChamado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}
	

	
}
