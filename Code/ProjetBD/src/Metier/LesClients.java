package Metier;
import java.util.ArrayList;
public class LesClients {
    protected ArrayList<Client> clients ;
    private int numclient = 1;

    public LesClients(ArrayList<Client> clients) {
        this.clients = clients;
    numclient = clients.size();
    }
    public LesClients(){
        this.clients=new ArrayList<Client>();
    }

    public void addClient(Client client) {
        clients.add(client);
        numclient++;
    }

  public int getNumClientDispo() {
    return numclient;
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