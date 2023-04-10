package br.com.poo.solid.interfaces;

public interface Geral<T> {
	
	String gravar(T objeto);
	T listar();
}
