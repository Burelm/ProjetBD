package Metier;

import java.util.ArrayList;


public class Panier {
	
	private ArrayList<Produit> listProduit = new ArrayList<Produit>(); //Liste des produit commandé
    

    public Panier(ArrayList<Produit> listProduit) {

        this.listProduit = listProduit;
    }
    public Panier() {
    }

    public ArrayList<Produit> getListProduit(){
        return listProduit;
    }

    public void setListProduit(ArrayList<Produit> listProduit){
        this.listProduit = listProduit;
    }
    public void addToListProduit(Produit produit){
        listProduit.add(produit);
    }
    public void delToListProduit(Produit produit){
        listProduit.remove(produit);
    }
    public int length(){
        return listProduit.size();
    }
}

