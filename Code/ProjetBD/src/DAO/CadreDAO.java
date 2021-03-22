package DAO;
import java.sql.Connection;
import Metier.Cadre;

public class CadreDAO extends DAO<Cadre>{
    
    public CadreDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Cadre obj) {
        try {
            this.connect.createStatement().executeQuery( 
            "INSERT INTO Cadre"
            + "VALUES("
            + obj.getRefTirage()+","+obj.getTaille()+","+obj.getModel()+")");
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
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Cadre WHERE RefTirage ="+refTirage);
            if(result.next()) 
                cadre = new Cadre(refTirage,result.getString("Taille"),result.getString("Model"));
            } catch (SQLException e) { e.printStackTrace();}
        return cadre;  
    }   
}
