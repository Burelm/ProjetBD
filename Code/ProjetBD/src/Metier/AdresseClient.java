package Metier;

public class AdresseClient {
    String nomRue;
    int numeroRue;
    String ville;
    int code_postal;
    public AdresseClient(String nomRue, int numeroRue, String ville, int code_postal) {
        this.nomRue = nomRue;
        this.numeroRue = numeroRue;
        this.ville = ville;
        this.code_postal = code_postal;
    }
    public String getNomRue() {
        return nomRue;
    }
    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }
    public int getNumeroRue() {
        return numeroRue;
    }
    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public int getCode_postal() {
        return code_postal;
    }
    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }
    public String AfficherAdrr() {
    	return "Rue: "+getNomRue()+" numero: "+getNumeroRue()+" ville: "+getVille()+" codePostal: "+getCode_postal();
    }
}