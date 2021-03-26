package DAO;

import Metier.FichierImage;
import Metier.Produit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FichierImageDAO extends DAO<FichierImage>{
    
    public FichierImageDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(FichierImage obj) {
    int id=obj.getIdImage();
    System.out.println("id avant "+id);
	try {
		if (id == -1) {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT max(idImage) AS ID FROM FichierImage");
		    id=1;
			if (result.next()) {
			  id=result.getInt("ID");
			  id=id+1;
			 
			}
		} else {
			id = obj.getIdImage();
		}
		int myInt = obj.isPartage() ? 1 : 0;
		
		this.connect.createStatement().executeQuery(
		"INSERT INTO FichierImage "
		+ "VALUES("
		+ id+", '"+obj.getChemin_acces()+"',"+obj.getNoClient()+",'"+obj.getPriseDeVue()+"','"+obj.getParamRetouche()+"','"
                + obj.getResolution()+"',"+myInt+", TO_DATE('"+obj.getDateDerniereUtilisation()+"','DD/MM/YYYY')"+")");
		return true;
	}
	catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
    }
    
    public FichierImage read(int idImage) {    
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM FichierImage WHERE idImage ="+idImage);
            if(result.next()) {
            	boolean partage = (result.getInt("Partage")==1) ? true : false;
                return new FichierImage(idImage,result.getInt("noClient"),result.getString("chemin_access"),result.getString("Resolution"),result.getString("paramRetouche"),result.getString("PriseDeVue"),partage,result.getString("dateDerniereUtilisation"));
            }
            } catch (SQLException e) { e.printStackTrace(); }
        return null;  
    }
    
    //Toute les Images du clients
    public ArrayList<FichierImage> readAll(int idClient) {
    	ArrayList<FichierImage> lesFichiersImage = new ArrayList<FichierImage>();
    	try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM FichierImage WHERE noClient ="+idClient);
            while (result.next()) {
            	boolean partage = (result.getInt("Partage")==1) ? true : false;
                lesFichiersImage.add(new FichierImage(result.getInt("idImage"),result.getInt("noClient"),result.getString("chemin_access"),result.getString("Resolution"),result.getString("paramRetouche"),result.getString("PriseDeVue"),partage,result.getString("dateDerniereUtilisation"))) ;
            }
            } catch (SQLException e) { e.printStackTrace(); }
        return lesFichiersImage;  
    }
    
    //récuperation des images que l'on peut utilisé dans un tirage
    public ArrayList<FichierImage> readImageAutoriser(int idClient) {
    	ArrayList<FichierImage> lesFichiersImage = new ArrayList<FichierImage>();
    	try {
            ResultSet result = this.connect.createStatement().executeQuery("Select idImage,chemin_access,noClient,PriseDeVue,paramRetouche,Resolution,Partage,DateUtilisation "
            		+"from FichierImage" + 
            		" where (Select count(Partage)" + 
            		" From FichierImage" + 
            		" where Partage=1 and noClient="+idClient+
            		" group by Partage)>0 and Partage=1");
           
            while (result.next()) {
            	
            	boolean partage = (result.getInt("Partage")==1) ? true : false;
                lesFichiersImage.add(new FichierImage(result.getInt("idImage"),result.getInt("noClient"),result.getString("chemin_access"),result.getString("Resolution"),result.getString("paramRetouche"),result.getString("PriseDeVue"),partage,result.getString("DateUtilisation"))) ;
            }
            } catch (SQLException e) { e.printStackTrace(); }
        return lesFichiersImage;  
    }
    
}
