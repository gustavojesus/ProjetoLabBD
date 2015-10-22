package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;

public class GruposDAO {
	
	private Connection c;
	
     public GruposDAO(){
    	 GenericDAO gDao = new GenericDAO();
    	 c= gDao.getConnection();
     }

     public List<Grupos> listaGrupos() throws SQLException{
    	 List<Grupos> lista = new ArrayList<Grupos>();
    	 String sql="SELECT  codigoGrupo,grupo, nomeTime FROM Times "
					+ "INNER JOIN Grupos ON Times.codigoTime = Grupos.codigoTime"
                    + "ORDER BY codigoGrupo, grupo ";
  
    	 PreparedStatement ps= c.prepareStatement(sql);
    	 ResultSet rs =ps.executeQuery();
    	 while( rs.next()){
    		 Grupos g= new Grupos();
    		 g.setCodigoGrupo(rs.getInt("codigoGrupo"));
    		 g.setGrupo(rs.getString("grupo"));
    		 g.setCodTime(rs.getInt("codTime"));
    		 lista.add(g);
    		 
    	 }
    	 rs.close();
    	 ps.close();
    	 
		return null;
    	 
    	 
    	 
     }
     
     
}
