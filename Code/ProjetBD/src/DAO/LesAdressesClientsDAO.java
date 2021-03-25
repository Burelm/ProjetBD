package DAO;

import java.sql.*;
import java.util.ArrayList;

import Metier.AdresseClient;


public class LesAdressesClientsDAO extends DAO<ArrayList<AdresseClient>>{
    public LesAdressesClientsDAO(Connection conn) {
        super(conn);
    }
    
    public ArrayList<AdresseClient> read(int id) {
        ArrayList<AdresseClient> lesAdressesClients = new ArrayList<AdresseClient>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesAdresseClients WHERE noClient = "+ id);
            while (result.next()) {
                lesAdressesClients.add(new AdresseClient(result.getString("nomRue"), result.getInt("noRue"),result.getString("Ville"), result.getInt("Code_Postal")));
            }
            
        } catch (SQLException e) { e.printStackTrace(); }
        return lesAdressesClients;
    }

	@Override
	public boolean create(ArrayList<AdresseClient> newClient) {
		int noClient=0;
		String nomRue="";
		int noRue=0;
		String ville="";
		int codePostale=0;
		
		try {
			
			this.connect.createStatement().executeQuery(
			"INSERT INTO LesAdresseClients (noClient, nomRue, noRue, Ville, Code_Postal)"
			+ " VALUES("+noClient+" ,"+"'"+nomRue+"' ,"+noRue+","+"'"+ville+"' ,"+codePostale+")");
			}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
		return true;
		
	}
   
}
