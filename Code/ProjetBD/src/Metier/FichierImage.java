package Metier;

import java.sql.Date;

public class FichierImage {
	private int idImage;
	private String chemin_acces;
	private String priseDeVue;
	private String paramRetouche;
	private String resolution;
	private boolean partage;
	private Date dateDerniereUtilisation;
	
	public int getIdImage() {
		return idImage;
	}
	public FichierImageDAO(int idImage, String chemin_acces, String priseDeVue, String paramRetouche, String resolution,
			boolean partage, Date dateDerniereUtilisation) {
		this.idImage = idImage;
		this.chemin_acces = chemin_acces;
		this.priseDeVue = priseDeVue;
		this.paramRetouche = paramRetouche;
		this.resolution = resolution;
		this.partage = partage;
		this.dateDerniereUtilisation = dateDerniereUtilisation;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public String getChemin_acces() {
		return chemin_acces;
	}
	public void setChemin_acces(String chemin_acces) {
		this.chemin_acces = chemin_acces;
	}
	public String getPriseDeVue() {
		return priseDeVue;
	}
	public void setPriseDeVue(String priseDeVue) {
		this.priseDeVue = priseDeVue;
	}
	public String getParamRetouche() {
		return paramRetouche;
	}
	public void setParamRetouche(String paramRetouche) {
		this.paramRetouche = paramRetouche;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public boolean isPartage() {
		return partage;
	}
	public void setPartage(boolean partage) {
		this.partage = partage;
	}
	public Date getDateDerniereUtilisation() {
		return dateDerniereUtilisation;
	}
	public void setDateDerniereUtilisation(Date dateDerniereUtilisation) {
		this.dateDerniereUtilisation = dateDerniereUtilisation;
	}

}
