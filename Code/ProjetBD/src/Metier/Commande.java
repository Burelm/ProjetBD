Class Commande
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
	
	private Set<Produit> listProduit = new HashSet<Produit>(); //Liste des produit commandé

	public Commande(int idCommande, String noClient,String date,String livraison,Boolean CodePromo,String Statut,int idAdresse) {
		this.idCommande=idCommande;	
		this.noClient = noClient;
		this.date = date;
		this.livraison = livraison;
		this.CodePromo=CodePromo;
		this.Statut=Statut;
		this.idAdresse=idAdresse;
	}

	public Commande(){
	}

	public int getidCommande() { 
		return idCommande; 
	}
	public void setidCommande(int idCommande) { 
		this.idCommande = idCommande; 
	}
	
	public String getnoClient() { 
		return noClient; 
	}
	public void setnoClient(String noClient){ 
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

	public String getCodePromo() { 
		return CodePromo; 
	}

	public void setCodePromo(Boolean CodePromo) {
		this.CodePromo=CodePromo:
	}
	
	public String getStatut() { 
		return Statut; 
	}

	public void setStatut(String Statut) {
		this.Statut=CodePromo:
	}
	///-------
	public String getCodePromo() { 
		return CodePromo; 
	}

	public void setCodePromo(int idAdresse) {
		this.idAdresse=idAdresse;
	}
	
	
}
