package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;
import fr.humanbooster.fx.cadeaux.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet({ "/connexion", "/sign-up", "/singup" })
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService = new UtilisateurServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On veut rediriger vers la page de connexion
		request.getRequestDispatcher("WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = utilisateurService
				.recupererUtilisateurParEmailEtMotDePasse(request.getParameter("EMAIL"), request.getParameter("PWD"));
		// On verifie que les bonnes information de connexion ont été saisies (que
		// l'utilisateur exist)
		if (utilisateur != null) {
			// On créé une session Http (par défaut cette session Http dure 60 minutes)
			HttpSession session = request.getSession(true);
			session.setAttribute("utilisateur", utilisateur);
			// On redirige vers l4url articles
			response.sendRedirect("catalogue");
		} else {
			// Si on rentre ici c'est que l'email ou password est incorrect
			// On enrichit l'objet request avec une notification d'erreur
			request.setAttribute("notification", "email/pwd incorrect");
			request.getRequestDispatcher("WEB-INF/connexion.jsp").forward(request, response);
		}
	}

}
