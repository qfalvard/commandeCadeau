package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.business.Ville;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;
import fr.humanbooster.fx.cadeaux.service.VilleService;
import fr.humanbooster.fx.cadeaux.service.impl.UtilisateurServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.VilleServiceImpl;

/**
 * Servlet implementation class InscriptionServlet
 * la servlet assure le traitement des requetes http
 */
@WebServlet(urlPatterns = { "/inscription" }, loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurService utilisateurService;
	private VilleService villeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
		utilisateurService = new UtilisateurServiceImpl();
		villeService = new VilleServiceImpl();

		if (utilisateurService.recupererUtilisateurs().isEmpty() && villeService.recupererVilles().isEmpty()) {
			villeService.ajouterVille("Grenoble");
			villeService.ajouterVille("Lyon");
			villeService.ajouterVille("Marseille");
			villeService.ajouterVille("Paris");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("villes", villeService.recupererVilles());
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Ville ville = villeService.recupererVilleParId(Long.parseLong(request.getParameter("ID_VILLE")));

		Utilisateur utilisateur = utilisateurService.ajouterUtilisateur(request.getParameter("NOM"),
				request.getParameter("PRENOM"), request.getParameter("EMAIL"), request.getParameter("MOT_DE_PASSE"),
				ville);
		// On enrichit l'objet request en lui donnant l'objet utilisateur que request
		// désignera comme "utilisateur"
		request.setAttribute("utilisateur", utilisateur);
		// On fait suivre à la JSP merciInscription
		request.getRequestDispatcher("WEB-INF/merciInscription.jsp").forward(request, response);
	}

}
