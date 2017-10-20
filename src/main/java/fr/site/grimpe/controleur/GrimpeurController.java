package fr.site.grimpe.controleur;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.site.grimpe.modele.Grimpeur;
import fr.site.grimpe.modele.Utilisateur;




public class GrimpeurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GrimpeurController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Utilisateur grimpeur = new Utilisateur();
//		grimpeur.setNom("khady");
//		grimpeur.setPrenom("BAR");
//		grimpeur.setAdresse("Conflans");
//		request.setAttribute("grimpeur", grimpeur);
		
		
		Grimpeur grimpeur = new Grimpeur();
		request.setAttribute("utilisateurs", grimpeur.recupererUtilisateurs());
		
		
	    //on dit a notre servlet d'afficher la page jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue/listeGrimpeurs.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//   ConnectionForm form = new ConnectionForm();
//   form.vérifierIndentifiants(request);
//   request.setAttribute("form", form);
		
		//on crée un objet utilisateur
		Utilisateur utilisateur =  new Utilisateur();
		
		//on charge les données
//		utilisateur.setId_p(Integer.parseInt(request.getParameter("id_p")));
		
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setAdresse(request.getParameter("adresse"));
		
		//on cree un objet grimpeur et on lui ajoute utilisateur
		Grimpeur grimpeur = new Grimpeur();
		grimpeur.addUtilisateur(utilisateur);
		
		
	
		//on recupére les tous les utilisateurs
		request.setAttribute("utilisateurs", grimpeur.recupererUtilisateurs());
		
   this.getServletContext().getRequestDispatcher("/WEB-INF/vue/listeGrimpeurs.jsp").forward(request, response);
		
	}

}
