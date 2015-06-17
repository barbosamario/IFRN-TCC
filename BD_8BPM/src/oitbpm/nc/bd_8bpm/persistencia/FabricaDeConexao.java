package oitbpm.nc.bd_8bpm.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	private String url = "jdbc:mysql://localhost:3306/projeto_8bpm";
	private String usuario = "root";
	private String senha = "12345";
	
	private static FabricaDeConexao fabricaDeConexao = null;
	
	private FabricaDeConexao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public Connection getConexao() throws SQLException{
			Connection conn;
			conn = DriverManager.getConnection(url,usuario,senha);
			return conn;
		}
		
		public static FabricaDeConexao getInstance(){
			if(fabricaDeConexao == null){
				fabricaDeConexao = new FabricaDeConexao();
			}
			return fabricaDeConexao;
		}
	}


