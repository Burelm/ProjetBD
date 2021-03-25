package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Album;

public class AlbumDAO extends DAO<Album>{
    
    public AlbumDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Album obj) {
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
		            "INSERT INTO Album"
		            + "VALUES("
		            + obj.getRefTirage()+","+obj.getTitre()+","+obj.getMiseEnPage()+","+obj.getDescriptif()+")");
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Album read(int refTirage) {
    	  Album album = new Album();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Album NATURAL JOIN tirage NATURAL JOIN Impression WHERE RefTirage ="+refTirage);
            if(result.next()) 
                album = new Album(result.getInt("idProduit"),result.getInt("idCommande"),refTirage,result.getInt("idImage"),result.getString("format_img"),result.getInt("Ordre"),result.getString("Titre"),result.getString("mieseEnPage"),result.getString("Descriptif"));
            } catch (SQLException e) { e.printStackTrace(); }
        return album;  
    }
}
