package DAO;
import java.sql.Connection;
import Metier.CodePromo;

public class CodePromoDAO extends DAO<CodePromo>{
    
    public CodePromoDAO(Connection conn) { 
        super(conn); 
    }
    
    public boolean create(CodePromo obj) {
        try {
            this.connect.createStatement().executeQuery(
            "INSERT INTO CodePromo"
            + "VALUES("
            + obj.getCodePromo()+","+obj.getNoClient()+")");
            return true;
        }
	      catch (SQLException e) {
		        e.printStackTrace();
		        return false;
	      }
    }
    
    public CodePromo read(int code) {
    	  CodePromo codepromo = new CodePromo();      
        try {
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM CodePromo WHERE CodePromo ="+code);
            if(result.next()) 
                codepromo = new CodePromo(code,result.getInt("noClient"));
            } catch (SQLException e) { e.printStackTrace(); }
        return codepromo;  
    }
    
}
