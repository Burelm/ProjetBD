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
			LesAdressesClientsDAO lesAdressesClientsDAO = new LesAdressesClientsDAO(connect);
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesCommandes WHERE idCommande ="+idCommande);
			if(result.next()) 
                return new Commande(idCommande,result.getInt("noClient"),result.getString("date"),result.getString("livraison"),result.getBoolean("CodePromo"),result.getString("Statut"),lesAdressesClientsDAO.readUneAdresse(result.getInt("idAdresse")));
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
			LesAdressesClientsDAO lesAdressesClientsDAO = new LesAdressesClientsDAO(connect);
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesCommandes WHERE noClient ="+noClient);
			while (result.next()) 
                lesCommandes.add(new Commande(result.getInt("idCommande"),result.getInt("noClient"),result.getString("date"),result.getString("livraison"),result.getBoolean("CodePromo"),result.getString("Statut"),lesAdressesClientsDAO.readUneAdresse(result.getInt("idAdresse"))));
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return lesCommandes;
	}

	@Override
	public boolean create(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
