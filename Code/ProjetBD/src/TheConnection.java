import java.sql.*;

public class TheConnection{
	
	private String url = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
	private String user = "hebertco";
	private String passwd = "fmaarg1Ox";
	private static Connection connect;
	private TheConnection(){
		try { 
			connect = DriverManager.getConnection(url, user, passwd); 
		}
		catch (SQLException e) { e.printStackTrace(); }
	}
	public static Connection getInstance(){
	if(connect == null){
		new TheConnection();
		System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
	}
	else { System.out.println("CONNEXION SQL EXISTANTE ! "); }
		return connect;
	}
	public static void stopConnection() {
		// TODO Auto-generated method stub
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
