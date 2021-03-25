package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Cadre;

public class CadreDAO extends DAO<Cadre>{
    
    public CadreDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Cadre obj) {
        try {
        	 this.connect.createStatement().executeQuery( 
     	            "INSERT INTO Tirage"
     	            + "VALUES("
     	            + obj.getIdProduit()+","+obj.getIdCommande()+","+obj.getrefTirage()+","+obj.getIdImage()+","+obj.getFormat()+")");
	         this.connect.createStatement().executeQuery( 
			         "INSERT INTO Impression"
			         + "VALUES("
			         + obj.getrefTirage()+","+obj.getOrdre()+")");
	         this.connect.createStatement().executeQuery( 
		            "INSERT INTO Cadre"
		            + "VALUES("
		            + obj.getrefTirage()+","+obj.getTaille()+","+obj.getModel()+")");
	          return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Cadre read(int refTirage) {
    	  Cadre cadre = new Cadre();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Cadre NATURAL JOIN tirage NATURAL JOIN Impression WHERE RefTirage ="+refTirage);
            if(result.next()) 
                cadre = new Cadre(result.getInt("idProduit"),result.getInt("idCommande"),refTirage,result.getInt("idImage"),result.getString("format_img"),result.getInt("Ordre"),result.getString("Taille"),result.getString("Model"));
            } catch (SQLException e) { e.printStackTrace();}
        return cadre;  
    }   
}
