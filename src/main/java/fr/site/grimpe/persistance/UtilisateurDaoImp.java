package fr.site.grimpe.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.site.grimpe.modele.Utilisateur;

public class UtilisateurDaoImp implements UtilisateurDao{
     private DaoFactory daoFactory;
     
	 UtilisateurDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
   
	public void ajouter(Utilisateur utilisateur) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		String sql;
		
		try {
			conn = daoFactory.getConnection();
		    sql = "INSERT INTO grimpeur(nom_grimpeur,prenom_grimpeur,adresse_grimpeur) VALUES(?,?,?)";
		    preparedStatement = conn.prepareStatement(sql);
		    preparedStatement.setString(1, utilisateur.getNom());
		    preparedStatement.setString(2, utilisateur.getPrenom());
		    preparedStatement.setString(3, utilisateur.getAdresse());
		   
		  //on execute la mise a jour des donnees
		    preparedStatement.executeUpdate();
		    } catch (SQLException e) {
			  e.printStackTrace();
	        }
		
	}

	public List<Utilisateur> lister() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql;
		
		
		try {
			
			sql="Select nom_grimpeur,prenom_grimpeur,adresse_grimpeur from grimpeur";
		    conn = daoFactory.getConnection();
	        statement = conn.createStatement();
		    resultSet = statement.executeQuery(sql);
		   
		    //récupération des données
	    while (resultSet.next()){
		     String nom = resultSet.getString("nom_grimpeur");
		     String prenom = resultSet.getString("prenom_grimpeur");
		     String adresse = resultSet.getString("adresse_grimpeur");
		     
		     //on  rée un objet utilisateur ou on stocke les données recupéré depuis notre table
		      Utilisateur utilisateur =  new Utilisateur();
		      utilisateur.setNom(nom);
		      utilisateur.setPrenom(prenom);
		      utilisateur.setAdresse(adresse);
		      
		      //on ajoute les utilisateurs ds notre liste 
		       utilisateurs.add(utilisateur);
		    	
		    }  
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return utilisateurs;
	}

	
	
}
