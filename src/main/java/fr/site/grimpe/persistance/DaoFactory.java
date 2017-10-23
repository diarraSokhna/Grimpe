package fr.site.grimpe.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
      private String url;
      private String username;
      private String password;
      
	public DaoFactory(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

   //méthode getInstance qui charge le driver et se connecte ala base
	public static DaoFactory getInstance() {
		try{
			
	         Class.forName("org.postgresql.Driver");	
		
		}catch(ClassNotFoundException e)	{
		}
		
		DaoFactory instance = new DaoFactory(
				"jdbc:postgresql://localhost:5432/Escalade" , "postgres", "0302");
		
		return instance;
		
	}
	//getConnection qui recupére la connection
	public Connection getConnection() throws SQLException {
		    Connection conn = DriverManager.getConnection(url, username, password);
	        conn.setAutoCommit(false);
	        return conn; 
	}

	 // Récupération du Dao
    public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImp(this);
    }
	
	
}
