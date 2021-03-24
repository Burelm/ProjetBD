package ressource;
import java.sql.*;

public class ClientDAO extends DAO<LesClients>{
	
	public ClientDAO(Connection conn) { 
		super(conn); 
	}
	
	public LesClients read() {
		LesClients listeClient=new LesClients();  
		Client client=new Client();
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesClients");
			while(result.next()) { 
				client = new Client(result.getInt("noClient"),result.getString("addr_mail"),result.getString("nom"),result.getString("prenom"),result.getString("mdp"));
				listeClient.addClient(client);}
			} catch (SQLException e) { e.printStackTrace(); }
		
		return listeClient;  
		}
	
}
