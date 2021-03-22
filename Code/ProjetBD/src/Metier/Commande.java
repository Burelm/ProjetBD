package Metier;

import java.util.HashSet;
import java.util.Set;
public class Commande {
	private int idCommande= 0;
	private int noClient = 0; //ID
	private String date = ""; //date 
	private String livraison = ""; //Prénom
	private Boolean CodePromo = false; //CodePromo
	private String Statut = ""; //Statut de la commande
	private int idAdresse=0; //identifiant adresse
	private float prix=0;
	private Set<Produit> listProduit = new HashSet<Produit>(); //Liste des produit commandé

	public Commande(int idCommande, int noClient,String date,String livraison,Boolean CodePromo,String Statut,int idAdresse) {
		this.idCommande=idCommande;	
		this.noClient = noClient;
		this.date = date;
		this.livraison = livraison;
		this.CodePromo=CodePromo;
		this.Statut=Statut;
		this.idAdresse=idAdresse;
		setListProduit();
		setPrix();
		
	}

	public Commande(){
	}

	public int getidCommande() { 
		return idCommande; 
	}
	public void setidCommande(int idCommande) { 
		this.idCommande = idCommande; 
	}
	
	public int getnoClient() { 
		return noClient; 
	}
	public void setnoClient(int noClient){ 
		this.noClient = noClient;
	}

	public String getdate() { 
		return date; 
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getlivraison() { 
		return livraison; 
	}

	public void setlivraison(String livraison) {
		this.livraison = livraison;
	}

	public boolean getCodePromo() { 
		return CodePromo; 
	}

	public void setCodePromo(Boolean CodePromo) {
		this.CodePromo=CodePromo;
	}
	
	public String getStatut() { 
		return Statut; 
	}

	public void setStatut(String Statut) {
		this.Statut=Statut;
	}
	public void setPrix(){
		for(Produit i:listProduit){
			this.prix+=i.getPrix();
		}
	}
	public void setListProduit(){
		//A voir ce qu'on met dedans
	}
	///-------
	

	public void setCodePromo(int idAdresse) {
		this.idAdresse=idAdresse;
	}
	
