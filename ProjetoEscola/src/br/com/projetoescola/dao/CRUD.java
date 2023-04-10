package br.com.projetoescola.dao;

import java.util.List;

public interface CRUD<T> {
	String gravar(T obj);
	List<T> listar();
	List<T> listar(T obj);
	T atualizar(T obj);
	String apagar(T obj);
	
	
	
}
