package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Produit;
import Metier.Produit.TypeI;
import Metier.Produit.TypeQ;

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
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Produit WHERE idProduit ="+idProduit);
            if(result.next()) {
            	return new Produit(idProduit, TypeI.valueOf(result.getString("typeImpr")),TypeQ.valueOf(result.getString("Qualite")),result.getFloat("Prix"),result.getString("Description"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    public ArrayList<Produit> readAllProduit() {
    	ArrayList<Produit> lesProduits = new ArrayList<Produit>();
    	try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Produit");
            while (result.next()) 
                lesProduits.add(new Produit(result.getInt("idProduit"),TypeI.valueOf(result.getString("typeImpr")),TypeQ.valueOf(result.getString("Qualite")),result.getFloat("Prix"),result.getString("Description")));
            } catch (SQLException e) { e.printStackTrace(); }
        return lesProduits;  
    }

    
}
