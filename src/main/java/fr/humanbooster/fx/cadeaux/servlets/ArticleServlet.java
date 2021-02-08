package fr.humanbooster.fx.cadeaux.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.cadeaux.business.Article;
import fr.humanbooster.fx.cadeaux.service.ArticleService;
import fr.humanbooster.fx.cadeaux.service.impl.ArticleServiceImpl;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet(urlPatterns = { "/article" }, loadOnStartup = 1)
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArticleService articleService = new ArticleServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("ID"));
		System.out.println(id);
		Article article = articleService.recupererArticleParId(id);
		// On enrichit l'objet request en lui donnant la liste d'articles
		request.setAttribute("article", article);
		System.out.println(article);
		//On fait suivre à la JSP articles.jsp
		request.getRequestDispatcher("WEB-INF/article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
