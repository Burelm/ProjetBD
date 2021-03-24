package Metier;
import java.util.ArrayList;
public class LesClients {
	protected ArrayList<Client> clients ;

	public LesClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public LesClients(){
		this.clients=new ArrayList<Client>();
	}

	public void addClient(Client client) {
		clients.add(client);
	}
	public void removeClient(Client client) {
		clients.remove(client);
	}
	public ArrayList<Client> getClients(){
		return clients;
	}
	public Client getClient(int i) {
		return clients.get(i);
	}
	
	public int indiceClientavecMail(String mail) {
		for(int i=0; i<clients.size();i++) {
			if (((String) clients.get(i).getMail()).equals(mail)) {
				return i;
			}
		}
		return -1;
	}
	
	
}
