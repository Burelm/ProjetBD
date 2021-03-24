package DAO;
import java.sql.Connection;
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
            + obj.getRefTirage() +"," + obj.getOrdre() + ")");
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public Impression read(int refImpression) {
    	  Impression impression = new Impression();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Impression WHERE RefTirage ="+refTirage);
            if(result.next()) 
                impression = new Impression(refTirage,result.getInt("Ordre"));
            } catch (SQLException e) { e.printStackTrace();}
        return impression;  
    }   
}
