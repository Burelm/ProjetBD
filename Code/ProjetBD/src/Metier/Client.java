Class Client
import java.util.HashSet;
import java.util.Set;
public class Client {
	private int noClient = 0; //ID
	private String nom = ""; //Nom du prof
	private String prenom = ""; //Prénom
	private String mail = ""; //mail
	private String mdp = ""; //mot de passe
	
	private Set<Adresse> listAdresse = new HashSet<Adresse>(); //Liste des adresses

	public Client(int noClient, String nom,String prenom,String mail,String mdp) {
		this.noClient = noClient;
		this.nom = nom;
		this.prenom = prenom;
		this.mail=mail
		this.mdp=mdp
	}

	public Client(){
	}

	public int getnoClient() { 
		return noClient; 
	}
	public void setnoClient(int noClient) { 
		this.noClient = noClient; 
	}
	
	public String getNom() { 
		return nom; 
	}
	public void setNom(String nom){ 
		this.nom = nom;
	}

	public String getPrenom() { 
		return prenom; 
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() { 
		return mail; 
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() { 
		return mdp; 
	}

	public void setMdp(String mdp) {
		this.mdp=mdp:
	}
	
	public Set<Adresse> getListAdresse() { 
		return listAdresse; 
	}

	//ajouté une liste à un client
	public void setListAdresse(Set<listAdresse> listAdresse){
		this.listAdresse = listAdresse; 
	}

	//Ajouté une matière à un client
	public void addAdresse(Adresse adresse){
		this.listAdresse.add(adresse);
	}
	//Retire une matière à un client
	public void removeMatiere(Adresse adresse){
		this.listAdresse.remove(Adresse) }
	}