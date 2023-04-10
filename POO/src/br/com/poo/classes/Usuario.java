package br.com.poo.classes;

//Esta classe é destinada a criação de novos usuários
public class Usuario {

	//atributos da classe
	public int id;
	public String nomeUsuario;
	public String senha;
	public String[] grupo;
	
	public void cadastrar() {
		System.out.println("O usuário: "+
							nomeUsuario+
							" foi cadastrado");
	}
	
	public void listarUsuario() {
		System.out.println(
				"\nId Usuário:"+id +
				"\nNome: "+nomeUsuario +
				"\nGrupo:"+grupo
				);
	}
}
