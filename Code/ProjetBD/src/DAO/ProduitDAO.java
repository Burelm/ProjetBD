package ressource;
import java.sql.*;

public class ProduitDAO extends DAO<Produit>{
    
    public ProduitDAO(Connection conn) { 
        super(conn); 
    }
    
    public Produit read(int id) {
        Produit produit = new Produit();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesClients WHERE noClient ="+id);
            if(result.next()) 
                client = new Client(id,result.getString("addr_mail"),result.getString("nom"),result.getString("prenom"),result.getString("mdp"));
            } catch (SQLException e) { e.printStackTrace(); }
        return client;  
        }
    
}
