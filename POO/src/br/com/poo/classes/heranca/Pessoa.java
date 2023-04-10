package br.com.poo.classes.heranca;

public abstract class Pessoa {

	//Atributos da classe Pessoa
	private int id;
	private String email;
	//Construtor da Classe Pessoa
	public Pessoa() {}
		//Construtor da Classe Pessoa com argumentos
		public Pessoa(int id, String email){
			this.id = id;
		}

		
		//Gerar os métodos de acesso get set 
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	
}
