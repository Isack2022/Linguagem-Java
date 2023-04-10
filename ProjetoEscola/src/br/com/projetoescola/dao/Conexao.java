package br.com.projetoescola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * A classe Conexao é destinada a abrir conexão com o banco de dados<br>
 * Nesta classe você encontrará os seguinte métodos:<br>
 * <ul>
 * 	<li><b>abrirConexao:</b> Abre a conexão com o banco escoladb</li>
 * 	<li><b>fecharConexao:</b> Fecha a conexão com o banco escoladb</li>
 * </ul>
 * @author Isack Santos
 * 
 *
 */
public abstract class Conexao {

	
	/*
	 * As propriedades(Atributos) da classe Conexao foram setados como
	 * protected, pois haverá um processo de herança desta classe e assim
	 * será possível passar os dados para as subclasses(classes filhas).
	 * O comando Connection é uma classe que permite estabelecer a 
	 * conexão com o banco de dados. Foi setado para esta classe a variável
	 * conn com o valor inicial nulo. Assim ela começa com algo e depois
	 * será instânciada.
	 * Já o comando PreparedStatement é utilizado para executar os 
	 * comandos de SQL, tais como: Insert, Update, Select, Delete, dentre
	 * outrs. A variável do prepared foi criada como pst e seu valor
	 * inicial é null.
	 * O comando ResultSet é destinado a guardar os resultados do 
	 * comando Select do mysql. A variável rs foi inicializada com
	 *  o valor null
	 * */
	protected Connection conn = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	/**
	 * O método <b>abrirConexao</b> abre a conexão com o banco de dados
	 * escoladb que está no servidor MySQL, que por sua vez está no
	 * container(docker).
	 */
	public void abrirConexao() {
		/*
		 * Os comandos try(tentar) ... catch(capturar), são utilizados 
		 * para realizar o tratamento de erros, onde try, você tenta
		 *  executar algo e caso dê erro o comando catch, captura
		 *  automaticamente o erro e o trata de acordo com o comando
		 *  printStackTrace, exibindo a pilha(Stack) de erros
		 */
		try {
			/*
			 * O Comando Class.forName é usado para carregar o drive de 
			 * comunicação com mysql
			 * */
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			/*
			 * Na linha abaixo é passado para o comando getConnection a 
			 * url de conexao com o banco de dados(ip, porta,banco de dados),
			 * o usuário e a senha. TimeZone foi definido como true
			 * */
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6556/escoladb?useTimeZone=true","root","senac@123");
		}
		catch(SQLException se) {
			/*
			 * Para tratamentos de erros específicos de sql, estamos usando
			 * a classe SQLException
			 * */
			se.printStackTrace();
		}
		catch(Exception e) {
			/*
			 * Para erros gerais, estamos usando o comando Exception
			 * */
			e.printStackTrace();
		}
	}
	
	public void fecharConexao() {
		try {
			/*
			 * O comando close é utilizado para a fechar
			 * a conexao com o servidor de banco de dados
			 * */
			conn.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
