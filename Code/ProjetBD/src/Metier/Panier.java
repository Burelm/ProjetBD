package Metier;

import java.util.ArrayList;


public class Panier {
	
	private ArrayList<Produit> listProduit = new ArrayList<Produit>(); //Liste des produit commandé
    

    public Panier(ArrayList<Produit> listProduit) {

        this.listProduit = listProduit;
    }
    public Panier() {

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
    public int length(){
        return listProduit.size();
    }
}
