package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.business.Categorie;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.CategorieService;
import fr.humanbooster.fx.cadeaux.service.impl.ArticleServiceImpl;
import fr.humanbooster.fx.cadeaux.service.impl.CategorieServiceImpl;

/**
 * Servlet implementation class ArticlesServlet
 * urlPatterns définit toutes les urls que la servlet prend en charge
 */
@WebServlet(urlPatterns = { "/catalogue", "/articles", "/index" }, loadOnStartup = 1)
public class ArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleService articleService = new ArticleServiceImpl();
	private CategorieService categorieService = new CategorieServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticlesServlet() {
        super();
		if (categorieService.recupereCategories().isEmpty() && articleService.recupereArticles().isEmpty()) {
			Categorie electromenager = categorieService.ajouterCategorie("Electromenager");
			Categorie jouet = categorieService.ajouterCategorie("Jouets");
			Categorie informatique = categorieService.ajouterCategorie("Informatique");
			Categorie telephonie = categorieService.ajouterCategorie("Telephonie");
			Categorie jeux = categorieService.ajouterCategorie("Jeux");
			Categorie gourmet = categorieService.ajouterCategorie("Gourmet");
			articleService.ajouterArticle("Cafetière Bialetti", 20, 50, gourmet);
			articleService.ajouterArticle("AirPods", 40, 100, jouet);
			articleService.ajouterArticle("Thermomix", 100, 25, gourmet);
			articleService.ajouterArticle("Train", 10, 200, jouet);
			articleService.ajouterArticle("MacBook", 1000, 75, informatique);
			articleService.ajouterArticle("Aspirateur Dyson", 500, 100, electromenager);
			articleService.ajouterArticle("OnePlus 6", 500, 75, telephonie);
			articleService.ajouterArticle("HTC VIVE", 750, 60, jeux);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupère la liste des articles en appelant le service associé
		List<Article> articles = articleService.recupereArticles();
		// On enrichit l'objet request en lui donnant la liste d'articles
		request.setAttribute("articles", articles);
		// On fait suivre à la JSP articles.jsp
		request.getRequestDispatcher("WEB-INF/articles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
