package fr.site.grimpe.persistance;

import java.util.List;

import fr.site.grimpe.modele.Utilisateur;

public interface UtilisateurDao {

	//d�finition de la fonction ajouter qui ajoute un utilisateur
	void ajouter(Utilisateur utilisateur);
	//fonction lister qui liste les utilisateurs
	List<Utilisateur> lister();
}
