package Metier;

import java.sql.Date;

public class FichierImage {
	private int idImage;
	private int noClient;
	private String chemin_acces;
	private String priseDeVue;
	private String paramRetouche;
	private String resolution;
	private boolean partage;
	private String dateDerniereUtilisation;
	
	public FichierImage(int idImage, int noClient, String chemin_acces, String priseDeVue, String paramRetouche, String resolution,
			boolean partage, String dateDerniereUtilisation) {
		this.idImage = idImage;
		this.noClient = noClient;
		this.chemin_acces = chemin_acces;
		this.priseDeVue = priseDeVue;
		this.paramRetouche = paramRetouche;
		this.resolution = resolution;
		this.partage = partage;
		this.dateDerniereUtilisation = dateDerniereUtilisation;
	}
	
	//Constructeur qui permet qui permet de ne pas spécifier d'ID image, il sera affecté lors de l'ajout à la base
	public FichierImage(int noClient, String chemin_acces, String priseDeVue, String paramRetouche, String resolution,
			boolean partage, String dateDerniereUtilisation) {
		this.idImage = -1;
		this.noClient = noClient;
		this.chemin_acces = chemin_acces;
		this.priseDeVue = priseDeVue;
		this.paramRetouche = paramRetouche;
		this.resolution = resolution;
		this.partage = partage;
		this.dateDerniereUtilisation = dateDerniereUtilisation;
	}
	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public int getNoClient() {
		return noClient;
	}
	public void setNoClient(int noClient) {
		this.noClient = noClient;
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
	public String getDateDerniereUtilisation() {
		return dateDerniereUtilisation;
	}
	public void setDateDerniereUtilisation(String dateDerniereUtilisation) {
		this.dateDerniereUtilisation = dateDerniereUtilisation;
	}

}
