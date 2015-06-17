package oitbpm.nc.bd_8bpm.persistencia;

import oitbpm.nc.bd_8bpm.negocio.Policial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PoliciaisDAO {
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public PoliciaisDAO(){
		
	}
	
	public int inserir(Policial policiais){
		int resultado = 0;
		try{
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn
					.prepareStatement("INSERT INTO policiais (nome,matricula) VALUES (?,?)");
			pst.setString(1, policiais.getNome());
			pst.setString(2, policiais.getMatricula());
			resultado = pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return resultado;
	}

	public int atualizarDadosPorId(Policial policiais){
		int resultado = 0;
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn.
					prepareStatement("UPDATE policiais SET nome = ?, matricula = ? WHERE id = ?");
			pst.setString(1, policiais.getNome());
			pst.setString(2, policiais.getMatricula());
			pst.setInt(3, policiais.getId());
			resultado = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return resultado;
		
	}
	
	public int excluirPorId(Policial policiais){
		int resultado = 0;
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn.
					prepareStatement("DELETE FROM policiais WHERE id = ?");
			pst.setInt(1, policiais.getId());
			resultado = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return resultado;
		
	}
	
	public Policial buscarPorCodigo(Policial policiais){
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn
					.prepareStatement("SELECT * FROM policiais WHERE id = ?");
			pst.setInt(1, policiais.getId());
			rs = pst.executeQuery();
			if(rs.next()){
				policiais.setNome(rs.getString(2));
				policiais.setMatricula(rs.getString(3));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			fecharConexao();
		}
		return policiais;
		
		}
	
	public List<Policial> buscarTodos(){
		List<Policial> policiais = new ArrayList<Policial>();
		try {
			conn = FabricaDeConexao.getInstance().getConexao();
			pst = conn
					.prepareStatement("SELECT id,nome,matricula FROM policiais");
			rs = pst.executeQuery();
			
			while(rs.next()){
				Policial policiais1 = new Policial();
				policiais1.setId(rs.getInt(1));
				policiais1.setNome(rs.getString(2));
				policiais1.setMatricula(rs.getString(3));
				
				policiais.add(policiais1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fecharConexao();
		}
		return policiais;
	}
	
	@SuppressWarnings("unused")
	private void fecharConexao1(){
		try{
			conn.close();	
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	private void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}