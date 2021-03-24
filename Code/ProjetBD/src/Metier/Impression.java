package Metier;
public class Impression extends Tirage {
	private int ordre;
	public Impression(int idCommande, int idProduit, int refTirage, int idImage, String format,int ordre) {
		super(idCommande, idProduit, refTirage, idImage, format);
		// TODO Auto-generated constructor stub
		setOrdre(ordre);
	}
	public Impression() {
		super();
		// TODO Auto-generated constructor stub
		setOrdre(-1);
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

}
