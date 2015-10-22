package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Times;

public class TimesDAO {
	
	
	
	
	private Connection c;
	
	public TimesDAO(){
		 GenericDAO gDao = new GenericDAO();
    	 c= gDao.getConnection(); 
	}
	
	public List<Times> listaTimes() throws SQLException{
   	 List<Times> lista = new ArrayList<Times>();
   	 String sql= "SELECT * FROM Times";
   	 PreparedStatement ps= c.prepareStatement(sql);
   	 ResultSet rs =ps.executeQuery();
   	 while( rs.next()){
   		
   		 Times t= new Times();
   		 t.setCodigoTime(rs.getInt("codigoTime"));
   		 t.setNomeTime(rs.getString("nometime"));
   		 t.setCidade(rs.getString("cidade"));
   		 t.setEstadio(rs.getString("estadio"));
   		 
   		 lista.add(t);
   		 
   	 }
   	 rs.close();
   	 ps.close();
   	 
		return null;
   	 
   	 
   	 
    }
    
	
	

}
