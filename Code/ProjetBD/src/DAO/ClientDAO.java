package DAO;
import java.sql.*;

import Metier.Client;
import Metier.LesClients;
public class ClientDAO extends DAO<LesClients>{
	
	public ClientDAO(Connection conn) { 
		super(conn); 
	}
	
	public LesClients read(int id) {
		LesClients listeClient=new LesClients();  
		Client client=new Client();
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesClients");
			while(result.next()) { 
				LesAdressesClientsDAO addr=new LesAdressesClientsDAO(connect);
				
				client = new Client(result.getInt("noClient"),result.getString("nom"),result.getString("prenom"),result.getString("addr_mail"),result.getString("mdp"));
				//System.out.println (result.getInt("noClient")+result.getString("nom")+result.getString("prenom")+result.getString("addr_mail")+result.getString("mdp"));
				client.setListAdresse(addr.read(result.getInt("noClient")));
				
				listeClient.addClient(client);}
			} catch (SQLException e) { e.printStackTrace(); }
		
		return listeClient;  
		}
	//ajout� un seule client 
	public boolean create(LesClients client) {
		int noClient=client.getClient(0).getnoClient();
		String nom=client.getClient(0).getNom();
		String prenom=client.getClient(0).getPrenom();
		String mail=client.getClient(0).getMail();
		String mdp=client.getClient(0).getMdp();
		//System.out.println("noclient: "+noClient+" "+nom);
		try {
			this.connect.createStatement().executeQuery(
			"INSERT INTO LesClients"
			+ " VALUES("+noClient+","+"'"+mail+"' ,"+"'"+nom+"' ,"+"'"+prenom+"' ,"+"'"+mdp+"' ,"+"0"+")");
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		return true;
	}

	

	
	
}
