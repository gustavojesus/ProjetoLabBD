package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {
	
	private Connection con;
	
	
	
	public Connection getConnection() {
		
	
			try {
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				con = DriverManager
						.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=CampeonatoPaulistano;namedPipe=true",
							"provalabbd", "123456");
				System.out.println("Conexao OK");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
		
	}
	
	
	public void fechaConexao(){
		if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	

}
