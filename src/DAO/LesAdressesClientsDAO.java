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
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesAdressesClients WHERE numeroClient = "+ id);
			while (result.next()) {
				lesAdressesClients.add(new AdresseClient(result.getString(1), result.getString(2), result.getString(3), result.getString(4)));
			}
			
		} catch (SQLException e) { e.printStackTrace(); }
		return lesAdressesClients;
	}
	public void create(String nomRue, String numeroRue, String ville, String code_postal) {
		try {
			this.connect.createStatement().executeQuery("INSERT INTO LesAdressesClients VALUES ("+ nomRue + ", " + numeroRue + ", " + ville + ", " + code_postal + ")");
		} catch (SQLException e) { e.printStackTrace(); }
	}
}

