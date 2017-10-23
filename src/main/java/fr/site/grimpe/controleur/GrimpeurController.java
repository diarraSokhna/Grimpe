package fr.site.grimpe.controleur;


import java.io.DataOutput;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.site.grimpe.modele.Utilisateur;
import fr.site.grimpe.persistance.DaoException;
import fr.site.grimpe.persistance.DaoFactory;
import fr.site.grimpe.persistance.UtilisateurDao;


public class GrimpeurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
       
    
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao =  daoFactory.getUtilisateurDao();
		
	}
	
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
		
		
		
	     try {
	            request.setAttribute("utilisateurs", utilisateurDao.lister());
	        }
	        catch (DaoException e) {
	            request.setAttribute("erreur", e.getMessage());
	        }
	    //on dit a notre servlet d'afficher la page jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue/listeGrimpeurs.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//   ConnectionForm form = new ConnectionForm();
//   form.vérifierIndentifiants(request);
//   request.setAttribute("form", form);
		
		 try {
		//on crée un objet utilisateur
		Utilisateur utilisateur =  new Utilisateur();
		//on charge les données
//		utilisateur.setId_p(Integer.parseInt(request.getParameter("id_p")));
		
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setAdresse(request.getParameter("adresse"));
		
		utilisateurDao.ajouter(utilisateur);
		//on recupére tous les utilisateurs
		request.setAttribute("utilisateurs", utilisateurDao.lister());
		
		   }
	        catch (Exception e) {
	            request.setAttribute("erreur", e.getMessage());
	        }
		 
        this.getServletContext().getRequestDispatcher("/WEB-INF/vue/listeGrimpeurs.jsp").forward(request, response);
		
	}

}
