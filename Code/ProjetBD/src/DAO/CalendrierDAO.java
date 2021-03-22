package DAO;
import java.sql.Connection;
import Metier.Calendrier;

public class CalendrierDAO extends DAO<Calendrier>{
    
    public CalendrierDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Calendrier obj) {
        try {
            this.connect.createStatement().executeQuery( 
            "INSERT INTO Calendrier"
            + "VALUES("
            + obj.getRefTirage()+","+obj.getmiseEnPage()+")");
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
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Calendrier WHERE RefTirage ="+refTirage);
            if(result.next()) 
                calendrier = new Calendrier(refTirage,result.getString("miseEnPage"));
            } catch (SQLException e) { e.printStackTrace();}
        return calendrier;  
    }   
}
