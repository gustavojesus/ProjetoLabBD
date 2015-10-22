package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;
import model.Times;

public class GruposDAO {
	
	private Connection c;
	
     public GruposDAO(){
    	 GenericDAO gDao = new GenericDAO();
    	 c= gDao.getConnection();
     }

     public void criarGrupos  () throws SQLException{
    	 String sql="{call sp_timesGrandes()}"; 
    	 CallableStatement cs=c.prepareCall(sql);	 
    	 cs.execute();
    	 
     }
     
    public List<Grupos> carregarGrupos(int g ){
    	List<Grupos>lista= new ArrayList<Grupos>();
    	try {
    		
        	String sql="SELECT nomeTime, grupo FROM Grupos"+
        				" INNER JOIN Times"+
        				" ON Grupos.codigoTime = Times.codigoTime"+
        				" WHERE codigoGrupo =?";
        	
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setInt(1,g);
			ResultSet rs= ps.executeQuery();
			
			
			Grupos gg=new Grupos();
			Times time = new Times();
			while(rs.next()){
				time.setNomeTime(rs.getString("nomeTime"));
				gg.setNomeTime(time);
				gg.setGrupo(rs.getString("grupo"));
				System.out.println(gg.getNomeTime());
				lista.add(gg);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
    	
    	
    	
    	
    	
    	  
    	 
     }
     
     
     
     
     
     
     
     
}
