package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Produit;

public class ProduitDAO extends DAO<Produit>{
    
    public ProduitDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(Produit obj) {
	try {
		this.connect.createStatement().executeQuery(
		"INSERT INTO Produit"
		+ "VALUES("
		+ obj.getID()+","+obj.getTypeImpr()+","+obj.getTypeQualite()+","+obj.getPrix()+","+obj.getDescription()+")");
		return true;
	}
	catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
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
