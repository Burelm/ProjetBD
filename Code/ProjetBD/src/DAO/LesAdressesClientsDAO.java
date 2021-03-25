package DAO;

import java.sql.*;
import java.util.ArrayList;

import Metier.AdresseClient;


public class LesAdressesClientsDAO extends DAO<ArrayList<AdresseClient>>{
	int noClient=-1;
    public LesAdressesClientsDAO(Connection conn) {
        super(conn);
    }
    
    public LesAdressesClientsDAO(Connection conn,int noClient) {
        super(conn);
        this.noClient=noClient;
    }
    
    public ArrayList<AdresseClient> read(int id) {
        ArrayList<AdresseClient> lesAdressesClients = new ArrayList<AdresseClient>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM LesAdresseClients WHERE noClient = "+ id);
            while (result.next()) {
                lesAdressesClients.add(new AdresseClient(result.getString("nomRue"), result.getInt("noRue"),result.getString("Ville"), result.getInt("Code_Postal")));
            }
            
        } catch (SQLException e) { e.printStackTrace(); }
        return lesAdressesClients;
    }
    
	@Override
	public boolean create(ArrayList<AdresseClient> newAddr) {
		int id=1;
		String nomRue=newAddr.get(0).getNomRue();
		int noRue=newAddr.get(0).getNumeroRue();
		String ville=newAddr.get(0).getVille();
		int codePostale=newAddr.get(0).getCode_postal();
		System.out.println("numC= "+noClient);
		if (noClient!=-1) {
			
			 try {
				 ResultSet result = this.connect.createStatement().executeQuery("SELECT max(idAdresse) AS ID FROM LesAdresseClients");
	              if (result.next()) {
				 	id=result.getInt("ID");
	                id=id+1;
	                System.out.println("id= "+id);
	              }  
		        } catch (SQLException e) { e.printStackTrace(); }

			try {
				this.connect.createStatement().executeQuery(
				"INSERT INTO LesAdresseClients (idAdresse,noClient, nomRue, noRue, Ville, Code_Postal)"
				+ " VALUES("+id+","+noClient+" ,"+"'"+nomRue+"' ,"+noRue+","+"'"+ville+"' ,"+codePostale+")");
				
				}
			
			catch (SQLException e) {
				e.printStackTrace();
				return false;
				}
			 }
		else {
			return false;
			}
		return true;
		
	}
	
   
}
