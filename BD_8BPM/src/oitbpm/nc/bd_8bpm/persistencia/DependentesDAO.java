package oitbpm.nc.bd_8bpm.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.negocio.Policial;

public class DependentesDAO {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public DependentesDAO(){
		
	}
	
	public int inserir(Dependente dependente){
		int resultado = 0;
		try{
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn
					.prepareStatement("INSERT INTO dependentes"
							+ " (conjuge,filhos,filiacao,codigo) VALUES (?,?,?,?)");
			pst.setString(1, dependente.getConjuge());
			pst.setString(2, dependente.getFilhos());
			pst.setString(3, dependente.getFiliacao());
			pst.setInt(4,dependente.getId());
			resultado = pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return resultado;
	}

	public int atualizarDadosPorId(Dependente dependentes){
		int resultado = 0;
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn.
					prepareStatement("UPDATE dependentes SET conjuge = ?, filhos = ?, filiacao = ? WHERE id_dependentes = ?");
			pst.setString(1, dependentes.getConjuge());
			pst.setString(2, dependentes.getFilhos());
			pst.setString(3, dependentes.getFiliacao());
			pst.setInt(4, dependentes.getId());
			resultado = pst.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return resultado;
		
	}
	
	public int excluirPorId(Dependente dependentes){
		
		int resultado = 0;
		
		try {
			
			conn = FabricaDeConexao.getInstance().getConexao();
			
			pst = conn.
					prepareStatement("DELETE FROM dependentes WHERE codigo = ?");
			
			pst.setInt(1, dependentes.getId());
			
			resultado = pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return resultado;
		
	}
	
	public Dependente buscarPorCodigo(Dependente dependentes){
		PoliciaisDAO policiaisDAO = new PoliciaisDAO();
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn
					.prepareStatement("SELECT * FROM dependentes WHERE codigo = ?");
			pst.setInt(1, dependentes.getId());
			rs = pst.executeQuery();
			if(rs.next()){
				dependentes.setId(rs.getInt(1));
				dependentes.setConjuge(rs.getString(2));
				dependentes.setFilhos(rs.getString(3));
				dependentes.setFiliacao(rs.getString(4));
				
				Policial policiais = new Policial();
				policiais.setId(rs.getInt(5));
				policiaisDAO.buscarPorCodigo(policiais);
				dependentes.setPolicial(policiais);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			fecharConexao();
		}
		return dependentes;
		
		}
	
	
	public List<Dependente> buscarTodos(){
		PoliciaisDAO policiaisDAO = new PoliciaisDAO();
		List<Dependente> dependentes = new ArrayList<Dependente>();
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn
					.prepareStatement("SELECT * FROM dependentes");
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				Dependente dependentes1 = new Dependente();
				dependentes1.setId(rs.getInt(1));
				dependentes1.setConjuge(rs.getString(2));
				dependentes1.setFilhos(rs.getString(3));
				dependentes1.setFiliacao(rs.getString(4));
				
				Policial policiais = new Policial();
				policiais.setId(rs.getInt(5));
				policiaisDAO.buscarPorCodigo(policiais);
				dependentes1.setResponsavel(policiais);
				
				dependentes.add(dependentes1);
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return dependentes;
	}
	
	private void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}
