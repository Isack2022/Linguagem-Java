package br.com.projetoescola.domain;

import java.sql.Date;

public class Curso {

	private Long idCurso;
	private String titulo;
	private String descricao;
	private Date datainicio;
	private Date datatermino;
	private String horarioinicio;
	private String horariotermino;
	
	public Curso() {
	}
	
	public Curso(Long idCurso, String titulo, String descricao, Date datainicio, Date datatermino, String horarioinicio,
			String horariotermino) {
		this.idCurso = idCurso;
		this.titulo = titulo;
		this.descricao = descricao;
		this.datainicio = datainicio;
		this.datatermino = datatermino;
		this.horarioinicio = horarioinicio;
		this.horariotermino = horariotermino;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatatermino() {
		return datatermino;
	}

	public void setDatatermino(Date datatermino) {
		this.datatermino = datatermino;
	}

	public String getHorarioinicio() {
		return horarioinicio;
	}

	public void setHorarioinicio(String horarioinicio) {
		this.horarioinicio = horarioinicio;
	}

	public String getHorariotermino() {
		return horariotermino;
	}

	public void setHorariotermino(String horariotermino) {
		this.horariotermino = horariotermino;
	}
	
	
	
}
