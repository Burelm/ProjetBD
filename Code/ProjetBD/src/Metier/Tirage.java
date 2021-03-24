package Metier;

public class Tirage {
	protected int idCommande;
	protected int idProduit;
	protected int refTirage;
	protected int idImage;
	protected String format;
	
	
	
	public Tirage(int idCommande, int idProduit, int refTirage, int idImage, String format) {
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.refTirage = refTirage;
		this.idImage = idImage;
		this.format = format;
	}
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getrefTirage() {
		return refTirage;
	}
	public void setRefTirage(int refTirage) {
		this.refTirage = refTirage;
	}
	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}


}
