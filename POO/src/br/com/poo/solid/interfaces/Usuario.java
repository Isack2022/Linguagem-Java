package br.com.poo.solid.interfaces;

public interface Usuario<T> extends Geral<T>{
	String alterarSenha(T us);
	
}
 