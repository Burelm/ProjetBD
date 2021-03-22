package ressource;
import java.sql.*;

public class ProduitDAO extends DAO<Produit>{
    
    public ProduitDAO(Connection conn) { 
        super(conn); 
    }
    
    public Produit read(int idProduit) {
        Produit produit = new Produit();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Produit WHERE idProduit ="+idProduit);
            if(result.next()) 
                produit = new Produit(idProduit,result.getTypeI("typeImpr"),result.getTypeQ("Qualite"),result.getFloat("Prix"),result.getString("Description"));
            } catch (SQLException e) { e.printStackTrace(); }
        return produit;  
        }
    
}
