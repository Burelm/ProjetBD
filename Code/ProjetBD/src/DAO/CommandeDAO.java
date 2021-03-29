package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.Commande;

public class CommandeDAO extends DAO<Commande>{

	public CommandeDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Commande read(int idCommande) {
		// TODO Auto-generated method stub
		try {
			
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesCommandes WHERE idCommande ="+idCommande);
			if(result.next()) 
                return new Commande(idCommande,result.getInt("noClient"),result.getString("dateCommande"),result.getString("livraison"),result.getBoolean("Promo"),result.getString("Statut"),result.getInt("idAdresse"));
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return null;
	}
	
	public ArrayList<Commande> readAll(int noClient) {
		// TODO Auto-generated method stub
		ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
		try {
			panierDAO panierDAO = new panierDAO(connect);
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesCommandes WHERE noClient ="+noClient);
			while (result.next()) {
                lesCommandes.add(new Commande(result.getInt("idCommande"),result.getInt("noClient"),result.getString("dateCommande"),result.getString("livraison"),result.getBoolean("Promo"),result.getString("Statut"),result.getInt("idAdresse"), panierDAO.read(result.getInt("idCommande"))));
			}
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return lesCommandes;
	}

	@Override
	public boolean create(Commande obj) {
		int id=obj.getidCommande();
		
		int myInt = obj.getCodePromo() ? 1 : 0;
		try {
			if (id == -1) {
    			ResultSet result = this.connect.createStatement().executeQuery("SELECT max(idCommande) AS ID FROM LesCommandes");
    		    id=1;
    			if (result.next()) {
    			  id=result.getInt("ID");
    			  id=id+1;
    			}
    		} else {
    			id = obj.getidCommande();
    		}
			obj.setidCommande(id);
				this.connect.createStatement().executeQuery( 
	            "INSERT INTO LesCommandes"
	            + " VALUES("+
	            id+","+obj.getnoClient()+", TO_DATE('"+obj.getdate()+"','DD/MM/YYYY')"+",'"+obj.getlivraison()+"',"+myInt+",'"+obj.getStatut()+"',"+obj.getIdAdresse()+")");
	           
				return true;
	        }
		      catch (SQLException e) {
			        e.printStackTrace();
			        return false;
		      }
		
	}

}
