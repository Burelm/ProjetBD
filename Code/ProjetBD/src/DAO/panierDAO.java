package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import Metier.Panier;
import Metier.Produit;
import Metier.Produit.TypeI;
import Metier.Produit.TypeQ;

public class panierDAO extends DAO<Panier> {
	
	public panierDAO(Connection conn) { 
		super(conn);
	}
	
	
	public boolean create(int id,Panier obj) {//à finir
		try {
			this.connect.createStatement().executeQuery(
			"INSERT INTO Panier"
			+ "VALUES("
			+obj.()+")");
			return true;
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
		
	}

	
	public  Panier read(int id) { //fait
	    Panier lePanier = new Panier();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Produit INNER JOIN PANIER ON"+
            	"PRODUIT.idProduit=PANIER.idProduit"+" where PANIER.IdCommande="+id);
            while (result.next()) {
            	lePanier.addTolistProduit(new Produit(result.getInt("idProduit"),TypeI.valueOf(result.getString("typeImpr")),TypeQ.valueOf(result.getString("Qualité")),result.getFloat("Prix"),result.getString("Description")));
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
	
	
	public  boolean delete(Panier obj) { //àfaire
		try {
			this.connect.createStatement().executeQuery(
			"DELETE FROM Panier"
			+ "WHERE("
			+obj.getIDCommande()+","+obj.getIDProduit()+")");
			return true;
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
	}
}
