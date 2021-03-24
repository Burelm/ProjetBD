package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Impression;


public class ImpressionDAO extends DAO<Impression>{
    
    public ImpressionDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Impression obj) {
        try {
            this.connect.createStatement().executeQuery( 
            "INSERT INTO Impression"
            + "VALUES("
            + obj.getIdCommande()+","+obj.getIdProduit()+","+obj.getrefTirage()+","+obj.getIdImage()+","+obj.getFormat()+","+obj.getOrdre()+")");
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Impression read(int refTirage) {
    	Impression impression = new Impression();      
         try {
             ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Tirage WHERE RefTirage ="+refTirage);
             if(result.next()) 
            	 impression = new Impression(result.getInt("idProduit"),result.getInt("idCommande"),refTirage,result.getInt("idImage"),result.getString("format_img"),result.getInt("Ordre"));
             } catch (SQLException e) { e.printStackTrace();}
         return impression;  
     }   }   

