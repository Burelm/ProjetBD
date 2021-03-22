package Metier;

import java.util.ArrayList;


public class Panier {
	
	private ArrayList<Produit> listProduit = new ArrayList<Produit>(); //Liste des produit commandé
    private int idCommande; //Commande

    public Panier(int idCommande,ArrayList<Produit> listProduit) {
        this.idCommande = idCommande;
        this.listProduit = listProduit;
    }
    

    public ArrayList<Produit> getlistProduit(){
        return listProduit;
    }

    public void setlistProduit(ArrayList<Produit> listProduit){
        this.listProduit = listProduit;
    }
    public void addTolistProduit(Produit produit){
        listProduit.add(produit);
    }
    public void delTolistProduit(Produit produit){
        listProduit.remove(produit);
    }
    public int getIDCommande(){
        return idCommande;
    }

    public void setIDCommande(int idCommande){
        this.idCommande = idCommande;
    }
}
