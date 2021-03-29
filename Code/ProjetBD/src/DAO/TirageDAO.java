package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Tirage;

public class TirageDAO extends DAO<Tirage>{
    
    public TirageDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Tirage obj) {
    	int id=obj.getrefTirage();
    	
        try {
        	if (id == -1) {
    			ResultSet result = this.connect.createStatement().executeQuery("SELECT max(RefTirage) AS ID FROM Tirage");
    		    id=1;
    			if (result.next()) {
    			  id=result.getInt("ID");
    			  id=id+1;
    			}
    		} else {
    			id = obj.getrefTirage();
    		}
        	System.out.println("id2 "+id);
            this.connect.createStatement().executeQuery( 
            "INSERT INTO Tirage"
            + " VALUES("
            +obj.getIdProduit()+","+obj.getIdCommande()+","+id+","+obj.getIdImage()+",'"+obj.getFormat()+"')");
            
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Tirage read(int refTirage) {
    	  Tirage tirage = new Tirage();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Tirage WHERE RefTirage ="+refTirage);
            if(result.next()) 
                tirage = new Tirage(result.getInt("idProduit"),result.getInt("idCommande"),refTirage,result.getInt("idImage"),result.getString("format_img"));
            } catch (SQLException e) { e.printStackTrace();}
        return tirage;  
    }   
}
