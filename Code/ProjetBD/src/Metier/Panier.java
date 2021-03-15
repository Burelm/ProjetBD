public class Panier {

    private int idProduit; //ID
    private int idCommande; //Commande

    public Panier(int idProduit, int idCommande) {
        this.idProduit = idProduit;
        this.idCommande = idCommande;
    }

    public int getIDProduit(){
        return idProduit;
    }

    public void setIDProduit(int idProduit){
        this.idProduit = idProduit;
    }

    public int getIDCommande(){
        return idCommande;
    }

    public void setIDCommande(int idCommande){
        this.idCommande = idCommande;
    }
}
