
import java.sql.*;
import java.util.ArrayList;

public class squelette_appli {
	// static final String CONN_URL =
	// "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
// Ne pas oublier d'anomymiser le PASSWD avant de rendre votre travail
	// static final String USER = "";
	// static final String PASSWD = "";
	private static final String configurationFile = "C:\\Users\\Marvin\\eclipse-workspace\\TPJDBC\\BD.properties";
	static Connection conn;

	public static void main(String args[]) {
		try {
			// Enregistrement du driver Oracle
			System.out.print("Loading Oracle driver... ");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("loaded");
			// Etablissement de la connection
			DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
			System.out.print("Connecting to the database... ");
			conn = DriverManager.getConnection(dap.getDatabaseUrl(), dap.getUsername(), dap.getPassword());
			System.out.println("connected");
			conn.setAutoCommit(true);
			
			// Liberation des ressources et fermeture de la connexion...
			conn.close();
			System.out.println("bye.");
			// traitement d'exception
		} catch (SQLException e) {
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());
		}
	}
}
