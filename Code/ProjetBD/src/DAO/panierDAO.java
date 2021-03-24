package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Metier.Panier;
import Metier.Produit;
import Metier.Produit.TypeI;
import Metier.Produit.TypeQ;

public class panierDAO extends DAO<Panier> {
	
	public panierDAO(Connection conn) { 
		super(conn);
	}
	
	
	public boolean create(int idCommande,Panier obj) {
		try {
			
			
			
			 PreparedStatement prepStmt = connect.prepareStatement(    
					    "insert into PANIER(idCommande,idProduit) values (?,?)");
			 connect.setAutoCommit(false);

			 for(int i=0;i<obj.getListProduit().size();i++) {
				 prepStmt.setInt(1, obj.getListProduit().get(i).getID());
				 prepStmt.setInt(2, idCommande);
				 prepStmt.addBatch();
			 }
			 prepStmt.executeBatch();
			 connect.commit();
			 return true;
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
		
	}

	
	public static  Panier read(int idCommande) { //fait
	    Panier lePanier = new Panier();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Panier where PANIER.IdCommande="+idCommande);
            while (result.next()) {
            	lePanier.addToListProduit(ProduitDAO.read(result.getInt("idProduit")));
            	}

        } catch (SQLException e) { e.printStackTrace(); }
        return lePanier;
    }
	
	
	public  boolean update(Panier obj) { //à faire
		boolean res=delete(obj);
		if(res) {
		res=create(obj);
		return res;
		}
		return res;
	}
	
	
	public  boolean delete(int idCommande) { //à faire
		try {
			this.connect.createStatement().executeQuery(
			"DELETE FROM Panier"
			+ "WHERE idCommande ="+idCommande);
			return true;
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
	}
}
