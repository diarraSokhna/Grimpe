package fr.site.grimpe.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Grimpeur {

	private Connection conn;
	public List<Utilisateur> recupererUtilisateurs() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
		
		
		//connexion à la base de données
		Statement state = null;
		ResultSet result = null;
		
		charmementdb();
		
		try{
	       state = conn.createStatement();
		    
		 //exécution de la requete
		    result = state.executeQuery("Select nom_grimpeur,prenom_grimpeur,adresse_grimpeur from grimpeur");
		  
		  //récupération des données
		    while (result.next()){
		    	String nom = result.getString("nom_grimpeur");
		    	String prenom = result.getString("prenom_grimpeur");
		    	String adresse = result.getString("adresse_grimpeur");
		    	
		    //on  rée un objet utilisateur ou on stocke les données recupéré depuis notre table
		      Utilisateur utilisateur =  new Utilisateur();
		      utilisateur.setNom(nom);
		      utilisateur.setPrenom(prenom);
		      utilisateur.setAdresse(adresse);
		      
		      //on ajoute les utilisateurs ds notre liste 
		       utilisateurs.add(utilisateur);
//		       System.out.println(nom);
		    }
		    	
		}catch (SQLException e){
		}
		
		finally {
		    	
		    	//fermeture de la connexion
		    	try{
		    		
		    		if (result != null)
		    			result.close();
		    		if (state != null)
		    			state.close();
		    		if (conn != null)
		    			conn.close();
		    	}catch (SQLException ignore){
		    	}
		    }
		  return utilisateurs;
		
	}
	 private void charmementdb(){
		//chargement du driver 
			try{
				
		         Class.forName("org.postgresql.Driver");	
			
			}catch(ClassNotFoundException e)	{
			}
			
			try {
				
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Escalade" , "postgres", "0302");
			
		 
	        }catch (SQLException e){
	        	
	        	e.printStackTrace();
	        }
	    }
	
	 
	 public void addUtilisateur(Utilisateur utilisateur){
		 //on appelle la methode qui charge et se connecte ala base
		 charmementdb();
		 
		 //on recupere les  valeurs entrees
		 try {
			PreparedStatement prepState = conn.prepareStatement("INSERT INTO grimpeur(nom_grimpeur,prenom_grimpeur,adresse_grimpeur) VALUES(?,?,?)");
		    
		
		    prepState.setString(1, utilisateur.getNom());
		    prepState.setString(2, utilisateur.getPrenom());
		    prepState.setString(3, utilisateur.getAdresse());
		    
		    
		    
		    //on execute la mise a jour des donnees
		    prepState.executeUpdate();
		 
		 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	
}
