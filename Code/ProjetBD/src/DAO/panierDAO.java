package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Metier.Panier;
import Metier.Produit;


public class panierDAO extends DAO<Panier> {
	ProduitDAO prod=new ProduitDAO(connect);
	public panierDAO(Connection conn) { 
		super(conn);
	}
	
	
	public boolean create(int idCommande,Panier obj) {
		try {		
			for (Produit prod : obj.getListProduit()) {
                this.connect.createStatement().executeQuery(
                        "INSERT INTO Panier"
                        + " VALUES("
                        + idCommande+","+prod.getID() +")");
            }
			 return true;
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
		
	}

	
	public  Panier read(int idCommande) { //fait
	    Panier lePanier = new Panier();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Panier where PANIER.IdCommande="+idCommande);
            while (result.next()) {
            	lePanier.addToListProduit(prod.read(result.getInt("idProduit")));
            	}

        } catch (SQLException e) { e.printStackTrace(); }
        return lePanier;
    }
	
	
	/*public  boolean update(Panier obj) { //à faire
		boolean res=delete(obj);
		if(res) {
		res=create(obj);
		return res;
		}
		return res;
	}
	*/
	
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


	@Override
	public boolean create(Panier obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
