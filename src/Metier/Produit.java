package Metier;

public class Produit {

    public enum TypeI {BONNE, MOYENNE, HAUTE} ;  
    public enum TypeQ {TIRAGE, IMPRESSION, CADRE, CALENDRIER, ALBUM} ;  

    private int idProduit; //ID
    private TypeI typeImpr; //Impression
    private TypeQ Qualite; //Qualité
    private float Prix; //Prix
    private String Description; //Description

    public Produit(int idProduit, TypeI typeImpr, TypeQ Qualite, float Prix, String Description) {
        this.idProduit = idProduit;
        this.typeImpr = typeImpr;
        this.Qualite = Qualite;
        this.Prix = Prix;
        this.Description = Description;
    }

    public int getID(){
        return idProduit;
    }

    public void setID(int idProduit){
        this.idProduit = idProduit;
    }

    public TypeI getTypeImpr(){
        return typeImpr;
    }

    public void setTypeImpr(TypeI typeImpr){
        this.typeImpr = typeImpr;
    }

    public TypeQ getTypeQualite(){
        return Qualite;
    }

    public void setTypeQualite(TypeQ Qualite){
        this.Qualite = Qualite;
    }

    public float getPrix(){
        return Prix;
    }

    public void setPrix(float Prix){
        this.Prix = Prix;
    }

    public String getDescription(){
        return Description;
    }

    public void setDescription(String Description){
        this.Description = Description;
    }

}



