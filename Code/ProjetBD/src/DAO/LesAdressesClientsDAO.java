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
   
}
