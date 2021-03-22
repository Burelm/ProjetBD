package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import Metier.Panier;


public class panierDAO extends DAO<Panier> {
	public panierDAO(Connection conn) { 
		super(conn);
	}
	
	public boolean create(Panier obj) {
		try {
			this.connect.createStatement().executeQuery(
			"INSERT INTO Panier"
			+ "VALUES("
			+obj.getIDCommande()+","+obj.getIDProduit()+")");
			return true;
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		
		
	}

	public  Panier read(int id) {
		Panier panier = null;
		try {
			ResultSet result=this.connect.createStatement().executeQuery(
			"SELECT * FROM Panier where idCommande =="+id);
			if (result.first()) {
				panier = new Panier(id,result.getInt("idProduit"));
			}
			return panier;	
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		return panier;
		
	}
	public  boolean update(Panier obj) {
		boolean res=delete(obj);
		if(res) {
		res=create(obj);
		return res;
		}
		return res;
	}
	
	public  boolean delete(Panier obj) {
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
