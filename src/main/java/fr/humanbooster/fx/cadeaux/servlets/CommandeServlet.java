package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Commande;
import fr.humanbooster.fx.cadeaux.business.Utilisateur;
import fr.humanbooster.fx.cadeaux.exceptions.StockInsuffisantException;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.CommandeService;
import fr.humanbooster.fx.cadeaux.service.UtilisateurService;
import fr.humanbooster.fx.cadeaux.service.impl.ArticleServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.CommandeServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet({ "/commande" })
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService articleService = new ArticleServiceImpl();
	private CommandeService commandeService = new CommandeServiceImpl();
	private UtilisateurService utilisateurService = new UtilisateurServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ZOOOOOOOOB    ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Article article = articleService.recupererArticleParId(Long.parseLong(request.getParameter("ID")));
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		int quantite = Integer.parseInt(request.getParameter("QUANTITE"));
		if (utilisateur != null) {
			try {
				Commande commande = commandeService.ajouterCommande(Calendar.getInstance().getTime(), quantite, article,
						utilisateur);
				utilisateurService.ajouterCommande(utilisateur, commande);
				articleService.ajouterCommande(article, commande);
				utilisateur.setNbPoints(utilisateur.getNbPoints() - article.getNbPoints());
				request.setAttribute("commande", commande);
				request.getRequestDispatcher("WEB-INF/merciCommande.jsp").forward(request, response);
			} catch (StockInsuffisantException e) {
				request.setAttribute("notification", "stock insuffisant");
				request.getRequestDispatcher("WEB-INF/erreur.jsp").forward(request, response);
			}
		} else {
            request.setAttribute("utilisateurNonConnecte", "Vous devez vous connecter pour commander!");
            request.getRequestDispatcher("WEB-INF/erreur.jsp").forward(request, response);
		}
	}

}
