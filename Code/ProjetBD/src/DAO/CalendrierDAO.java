package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Calendrier;

public class CalendrierDAO extends DAO<Calendrier>{
    
    public CalendrierDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Calendrier obj) {
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
		            "INSERT INTO Calendrier"
		            + "VALUES("
		            + obj.getrefTirage()+","+obj.getMiseEnPage()+")");
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Calendrier read(int refTirage) {
    	  Calendrier calendrier = new Calendrier();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Calendrier NATURAL JOIN tirage NATURAL JOIN Impression WHERE RefTirage ="+refTirage);
            if(result.next()) 
                calendrier = new Calendrier(result.getInt("idProduit"),result.getInt("idCommande"),refTirage,result.getInt("idImage"),result.getString("format_img"),result.getInt("Ordre"),result.getString("miseEnPage"));
            } catch (SQLException e) { e.printStackTrace();}
        return calendrier;  
    }   
}
