public class Album{
	
	private String titre ="";
	private String miseEnPage ="";
	private String descriptif =""; 
	
	public Album(String titre,String miseEnPage,String descriptif,int idCommande,int idProduit,int refTirage,int idImage,String format,int ordre){
		super(idCommande, idProduit, refTirage, idImage, format, ordre);
		this.titre=titre;
		this.miseEnPage=miseEnPage;
		this.descriptif=descriptif;
	}

	public int getRefTirage() {
		return refTirage;
	}

	public void setRefTirage(int refTirage) {
		this.refTirage = refTirage;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMiseEnPage() {
		return miseEnPage;
	}

	public void setMiseEnPage(String miseEnPage) {
		this.miseEnPage = miseEnPage;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	
}
