package Metier;


import java.util.ArrayList;

public class Client {
	private int noClient = 0; //ID
	private String nom = ""; //Nom du prof
	private String prenom = ""; //Pr�nom
	private String mail = ""; //mail
	private String mdp = ""; //mot de passe
	
	private ArrayList<AdresseClient> listAdresse = new ArrayList<AdresseClient>(); //Liste des adresses

	public Client(int noClient, String nom,String prenom,String mail,String mdp) {
		this.noClient = noClient;
		this.nom = nom;
		this.prenom = prenom;
		this.mail=mail;
		this.mdp=mdp;
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
		this.mdp=mdp;
	}
	
	public ArrayList<AdresseClient> getListAdresse() { 
		return listAdresse; 
	}

	//ajout� une liste � un client
	public void setListAdresse(ArrayList<AdresseClient> listAdresse){
		this.listAdresse = listAdresse; 
	}

	
	public void addAdresse(AdresseClient adresse){
		this.listAdresse.add(adresse);
	}
	
	public void removeAdresse(AdresseClient adresse){
		this.listAdresse.remove(adresse); }
	}
