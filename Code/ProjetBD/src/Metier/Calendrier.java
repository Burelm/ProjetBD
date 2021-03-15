package Calendrier;

public class Impression extends Impression {
    private String miseEnPage;
  
    public Calendrier(int idCommande, int idProduit, int refTirage, int idImage, String format, int ordre, String miseEnPage) {
        super(idCommande, idProduit, refTirage, idImage, format, ordre);
		    setMiseEnPage(miseEnPage);
	  }
	  public String getMiseEnPage() {
		    return miseEnPage;
	  }
	  public void setMiseEnPage(String MiseEnPage) {
		    this.miseEnPage = miseEnPage;
	  }
}
