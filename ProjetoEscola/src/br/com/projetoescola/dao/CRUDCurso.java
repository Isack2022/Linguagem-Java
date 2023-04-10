package br.com.projetoescola.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoescola.domain.Curso;

public class CRUDCurso extends Conexao implements CRUD<Curso>{

	@Override
	public String gravar(Curso obj) {
		String msg = "";
		try {
			abrirConexao();
			String sql = "insert into curso(titulo,descricao,datainicio,datatermino,horarioinicio,horariotermino)values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			//Passar os paramentos pa os pontos de interrogação 
			pst.setString(1, obj.getTitulo());
			pst.setString(2, obj.getDescricao());
			pst.setDate(3, obj.getDatainicio());
			pst.setDate(4, obj.getDatatermino());
			pst.setString(5, obj.getHorarioinicio());
			pst.setString(6, obj.getHorariotermino());
			
			/*
			 * Quando executamos a consulta usando o comando executeUpdate ele
			 * retorna um número que pode ser 1 ou 0(zero), sendo 1 quando o dado 
			 * é inserido e 0(zero) quando o dado não é inserido
			 */
			int i = pst.executeUpdate();
			
			if(i>0) {
				msg = "Curso cadastro com sucesso!";
			}
			
			else{
				msg = "Não foi possível cadastrar";
			}
			
		}
			
		
		catch(SQLException se){
			msg = "Error de SQL: "+ se.getMessage();
		}
		catch(Exception e){
			msg = "Error inesperado: "+ e.getMessage();
		}
		
			
		finally {
			fecharConexao();
		}
		
		return msg;
		
	}

	@Override
	public List<Curso> listar() {
		/*
		 * Vamos criar uma lista de curoso, onde sua implementação é
		 * um array de cursos no formanto de uma lista de cursos.
		 * Assim teremos linhas  e colunas para os cursos
		 */
		List<Curso> lstCurso = new ArrayList<Curso>();
		
		try {
			abrirConexao();
			String sql = "Select * from curso";
			//Preparar a consulta para ser executada
			pst = conn.prepareStatement(sql);
			
			/*
			 * O comando executeQuery é utilizando para executar comandos de select.
			 * O retorno do executeQuery é um ResultSet, portanto é necessário que haja
			 * uma variável do tipo ResultSet para guadar o retorno da execução. Estamos
			 * usando a variável rs que foi declarada na classe Conexao
			 */
			rs = pst.executeQuery();
			
			/*
			 * Enquato houver dados na tabela de banco dados o laço continua a buscar
			 * os dados. O comando next() do rs captura dados da tabela e adciona em novo curso.
			 */
			while(rs.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(rs.getLong(1));
				curso.setTitulo(rs.getString(2));
				curso.setDescricao(rs.getString(3));
				curso.setDatainicio(rs.getDate(4));
				curso.setDatatermino(rs.getDate(5));
				curso.setHorarioinicio(rs.getString(6));
				curso.setHorariotermino(rs.getString(7));
				
				//Adiciona um novo curso na lista de curso.
				lstCurso.add(curso);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			fecharConexao();
		}
		
		return lstCurso;
	}

	@Override
	public List<Curso> listar(Curso obj) {
		/*
		 * Vamos criar uma lista de curoso, onde sua implementação é
		 * um array de cursos no formanto de uma lista de cursos.
		 * Assim teremos linhas  e colunas para os cursos
		 */
		List<Curso> lstCurso = new ArrayList<Curso>();
		
		try {
			abrirConexao();
			String sql = "";
			if(obj.getIdCurso()!=null) {
				 sql = "Select * from curso WHERE idcurso"+obj.getIdCurso();
			}
			else if(obj.getTitulo()!=null) {
				 sql = "Select * from curso WHERE titulo like "+obj.getTitulo()+"%";
			}else if(obj.getDescricao()!=null) {
				 sql = "Select * from curso WHERE descricao like %"+obj.getDescricao()+"%";
			}
			else {
				sql = "Select * from curso";
			}
			
			
			//Preparar a consulta para ser executada
			pst = conn.prepareStatement(sql);
			
			/*
			 * O comando executeQuery é utilizandi para executar comandos de select.
			 * O retorno do executeQuery é um ResultSet, portanto é necessário que haja
			 * uma variável do tipo ResultSet para guadar o retorno da execução. Estamos
			 * usando a variável rs que foi declarada na classe Conexao
			 */
			rs = pst.executeQuery();
			
			/*
			 * Enquato houver dados na tabela de banco dados o laço continua a buscar
			 * os dados. O comando next() do rs captura dados da tabela e adciona em novo curso.
			 */
			while(rs.next()) {
				Curso curso = new Curso();
				
				curso.setIdCurso(rs.getLong(1));
				curso.setTitulo(rs.getString(2));
				curso.setDescricao(rs.getString(3));
				curso.setDatainicio(rs.getDate(4));
				curso.setDatatermino(rs.getDate(5));
				curso.setHorarioinicio(rs.getString(6));
				curso.setHorariotermino(rs.getString(7));
				
				//Adiciona um novo curso na lista de curso.
				lstCurso.add(curso);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			fecharConexao();
		}
		
		return lstCurso;
	}

	@Override
	public Curso atualizar(Curso obj) {
		Curso curso = new Curso();
		try {
			abrirConexao();
		
			String sql = "update curso set titulo=?,descricao=?,datainicio=?,datatermino=?,horarioinicio=?,horariotermino=? WHere idcurso=?";
			pst = conn.prepareStatement(sql);
			//Passar os paramentos pa os pontos de interrogação 
			pst.setString(1, obj.getTitulo());
			pst.setString(2, obj.getDescricao());
			pst.setDate(3, obj.getDatainicio());
			pst.setDate(4, obj.getDatatermino());
			pst.setString(5, obj.getHorarioinicio());
			pst.setString(6, obj.getHorariotermino());
			pst.setLong(7, obj.getIdCurso());
		
			int i = pst.executeUpdate();
		
			if(i>0) {
				curso = obj;
			}
		
			else{
				//Exibir mensagem de erro mesmo sem retorno de String
				throw new Exception("Não foi possível atualizar");
			}
		
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			fecharConexao();
		}
		
		return curso;
	
	}

	@Override
	public String apagar(Curso obj) {
		String msg="";
		try {
			abrirConexao();
			String sql = "Delete from curso where idcurso=?";
			pst = conn.prepareStatement(sql);
			//Passar os paramentos pa os pontos de interrogação 
			pst.setLong(1, obj.getIdCurso());
			int i = pst.executeUpdate();
			if(i>0) {
				msg="Curso apagando";
			}else {
				msg = "Não foi possível apagar o curso";
			}
		}
		catch(SQLException se) {
			msg= "Error na consulta de SQL: "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Error inesperado: "+e.getMessage();
		}
		
		finally {
			fecharConexao();
		}
		return msg;
	}

}
