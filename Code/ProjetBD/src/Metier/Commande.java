package Metier;


public class Commande {
	private int idCommande= 0;
	private int noClient = 0; //ID
	private String date = ""; //date 
	private String livraison = ""; //Prénom
	private Boolean CodePromo = false; //CodePromo
	private String Statut = ""; //Statut de la commande
	private AdresseClient adresseClient; //identifiant adresse
	private float prix=0;
	private Panier panier = new Panier(); //Liste des produit commandé


	public Commande(int idCommande,int noClient,String date,String livraison,Boolean CodePromo,String Statut,AdresseClient adresseClient) {
		this.idCommande=idCommande;
		this.noClient = noClient;
		this.date = date;
		this.livraison = livraison;
		this.CodePromo=CodePromo;
		this.Statut=Statut;
		this.adresseClient=adresseClient;
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
	
	public AdresseClient getIdAdresse() {
		return adresseClient;
	}

	public void setAdresse(AdresseClient adresseClient) {

		this.adresseClient = adresseClient;
	}

	public String getStatut() { 
		return Statut; 
	}

	public void setStatut(String Statut) {
		this.Statut=Statut;
	}
	public void setPrix(){
		for(int i=0;i<panier.length();i++){
			this.prix+=panier.getListProduit().get(i).getPrix();
		}
	}
	public float getPrix(){
		return this.prix;
	}
	
	public void setListProduit(){
		//A voir ce qu'on met dedans
	}
	///-------
	public Panier getPanier(){
		return this.panier;
	}

	public void setCodePromo(AdresseClient adresseClient) {
		this.adresseClient=adresseClient;
	}
	
	
}
