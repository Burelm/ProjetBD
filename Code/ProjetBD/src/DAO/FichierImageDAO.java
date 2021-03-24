package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.FichierImage;

public class FichierImageDAO extends DAO<FichierImage>{
    
    public FichierImageDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(FichierImage obj) {
	try {
		this.connect.createStatement().executeQuery(
		"INSERT INTO FichierImage"
		+ "VALUES("
		+ obj.getIdImage()+","+obj.getNoClient()+","+obj.getChemin_acces()+","+obj.getPriseDeVue()+","+obj.getParamRetouche()+","
                + obj.getResolution()+","+obj.isPartage()+","+obj.getDateDerniereUtilisation()+")");
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
            if(result.next()) 
                return new FichierImage(idImage,result.getInt("idClient"),result.getString("chemin_access"),result.getInt("noClient"),result.getString("Resolution"),result.getDate("dateDerniereUtilisation"),result.getString("paramRetouche"),result.getString("paramRetouche"),result.getString("PriseDeVue"),result.getBoolean("Partage"));
            } catch (SQLException e) { e.printStackTrace(); }
        return null;  
    }
    
}
