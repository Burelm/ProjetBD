package Metier;

public class LesAdressesClients {
	private String nomRue;
	private String ville;
	private String codePostal;
	
	public LesAdressesClients(String nomRue, String ville, String codePostal) {
		this.nomRue = nomRue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
}
