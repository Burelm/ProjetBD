
public class Cadre extends Impression {
	private String taille;
	private String model;
	public Cadre(int idCommande, int idProduit, int refTirage, int idImage, String format, int ordre,String taille,String model) {
		super(idCommande, idProduit, refTirage, idImage, format, ordre);
		// TODO Auto-generated constructor stub
		setTaille(taille);
		setModel(model);
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	

}
