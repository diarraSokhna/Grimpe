package fr.site.grimpe.modele;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String adresse;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws BeanException {
        if (nom.length() > 10) {
            throw new BeanException("Le nom ne doit pas dépasser 10 caractères ");
        }
        else {
            this.nom = nom; 
        }
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
