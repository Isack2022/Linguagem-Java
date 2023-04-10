package br.com.projetoacessoria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoacessoria.domain.Chamado;

public class CRUDChamado extends Conexao implements CRUD<Chamado>{

	@Override
	public String registrar(Chamado obj) {
		String txt = "";
		
		try {
			abrirConexao();
			String sql = "INSERT INTO chamando(solicitacao,departamento,descricao)values(?,?,?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, obj.getSolicitacao());
			pst.setString(2, obj.getDepSolicitado());
			pst.setString(3, obj.getDescChamado());
			
			int i = pst.executeUpdate();
			if(i > 0) {
				txt = "Chamado solicitado com sucesso.";
			}
			else {
				txt = "Não foi possível realizar o chamado.";
			}
		}
		catch(SQLException se) {
			txt = "Erro de SQL -> " + se.getMessage();
		}
		catch(Exception e) {
			txt = "Erro inesperado -> " + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return txt;
	}

	@Override
	public List<Chamado> listar() {
		List<Chamado> lstChamado = new ArrayList<Chamado>();
		 try {
			 abrirConexao();
			 String sql = "SELECT * FROM chamando";
			 pst = conn.prepareStatement(sql);
			 /*
				 * O comando executeQuery é utilizado para executar comandos
				 * de SELECT. O retorno do executeQuery é um ResultSet,
				 * portanto é necessário que haja uma váriavel do tipo ResultSet
				 * para guardar o retorno da execução. Estamos usando a variavel rs
				 * que foi declarada na classe Conexao
				 * */
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setIdChamado(rs.getLong(1));
				chamado.setSolicitacao(rs.getString(2));
				chamado.setDepSolicitado(rs.getString(3));
				chamado.setDescChamado(rs.getString(4));
				chamado.setDataAbertura(rs.getDate(5));
				chamado.setDataResolucao(rs.getDate(6));
				chamado.setStatusChamado(rs.getString(7));
				chamado.setAtendente(rs.getString(8));
			
				lstChamado.add(chamado);
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
		
		return lstChamado;
	}

	@Override
	public List<Chamado> listar(Chamado obj) {
		List<Chamado> lstChamado = new ArrayList<Chamado>();
		
		try {
			abrirConexao();
			String sql = "";
			
			if(obj.getIdChamado() != 0) {
				sql = "Select * from chamando WHERE idcadastros=" + obj.getIdChamado();
			}
			else if(obj.getDepSolicitado() != null) {
				sql = "Select * from chamado WHERE departamento like " + obj.getDepSolicitado();
			}
			else if(obj.getSolicitacao() != null) {
				sql = "Select * from chamado WHERE solicitacao like " + obj.getSolicitacao() + "%";
			}
			else if(obj.getDescChamado() != null) {
				sql = "Select * from chamado WHERE descricao like %" + obj.getDescChamado() + "%";
			}
			else if(obj.getDataAbertura() != null) {
				sql = "Select * from chamado WHERE dataabertura like " + obj.getDataAbertura();
			}
			else if(obj.getStatusChamado() != null) {
				sql = "Select * from chamado WHERE statuschamado like " + obj.getStatusChamado();
			}
			else {
				sql = "Select * from chamando";
			}
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			/*
			 * Enquanto houver dados na tabela de banco de dados o laço 
			 * continua a buscar os dados. O comando next() do rs captura 
			 * dados da tabela e adiciona em novo curso.
			 * */
			while(rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setIdChamado(rs.getLong(1));
				chamado.setSolicitacao(rs.getString(2));
				chamado.setDepSolicitado(rs.getString(3));
				chamado.setDescChamado(rs.getString(4));
				chamado.setDataAbertura(rs.getDate(5));
				chamado.setDataResolucao(rs.getDate(6));
				chamado.setStatusChamado(rs.getString(7));
				chamado.setAtendente(rs.getString(8));
			
				lstChamado.add(chamado);
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
		return lstChamado;
	}

	@Override
	public Chamado atualizar(Chamado obj) {
		Chamado chamado = new Chamado();
		try {
			abrirConexao();
			String sql = "UPDATE chamando SET dataresolucao=?, statuschamando?, nomefun=? WHERE idcadastros=?";
			pst = conn.prepareStatement(sql);
			pst.setDate(1, obj.getDataResolucao());
			pst.setString(2, obj.getStatusChamado());
			pst.setString(3, obj.getAtendente());
			pst.setLong(4, obj.getIdChamado());
			
			int i = pst.executeUpdate();
			if(i > 0) {
				chamado = obj;
			}
			else {
				throw new Exception("Não foi possível atuaizar os dados");
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
		return chamado;
	}

	@Override
	public String apagar(Chamado obj) {
		String txt = "";
		try {
			abrirConexao();
			String sql = "DELETE FROM chamando WHERE idcadastros=?";
			pst = conn.prepareStatement(sql);
			pst.setLong(1, obj.getIdChamado());
			
			int i = pst.executeUpdate();
			if(i > 0) {
				txt = "Chamado apagado.";
			}
			else {
				txt = "Não foi possível apagar o chamado.";
			}
		}
		catch(SQLException se) {
			txt = "Erro na consulta de SQL -> " + se.getMessage();
		}
		catch(Exception e) {
			txt = "Ocorreu um erro inesperado durante a consulta -> " + e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return txt;
	}

}
