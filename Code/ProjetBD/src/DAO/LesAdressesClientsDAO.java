package DAO;
import java.sql.Connection;
import Metier.LesAdressesClients;


public class LesAdressesClientsDAO extends DAO<LesAdressesClients>{
	public LesAdressesClientsDAO(Connection conn) {
		super(conn);
	}
	
	public LesAdressesClients read(int id) {
		LesAdressesClients lesAdressesClients = new ArrayList<AdresseClient>
	}
}
