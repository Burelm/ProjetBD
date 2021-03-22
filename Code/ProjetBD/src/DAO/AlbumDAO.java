package DAO;
import java.sql.Connection;
import Metier.Album;

public class AlbumDAO extends DAO<Album>{
    
    public AlbumDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Album obj) {
        try {
            this.connect.createStatement().executeQuery( 
            "INSERT INTO Album"
            + "VALUES("
            + obj.getRefTirage()+","+obj.getTitre()+","+getMiseEnPage()+","+getDescriptif()+")");
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Album read(int refTirage) {
    	  Album codepromo = new Album();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Album WHERE Album ="+refTirage);
            if(result.next()) 
                codepromo = new Album(refTirage,result.getString("Titre"),result.getString("mieseEnPage"),result.getString("Descriptif"));
            } catch (SQLException e) { e.printStackTrace(); }
        return codepromo;  
    }
    
}