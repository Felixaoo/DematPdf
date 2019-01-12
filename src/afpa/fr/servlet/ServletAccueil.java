package afpa.fr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afpa.fr.service.ServicesAuthentification;
import afpa.fr.service.ServicesRecupDonnées;

/**
 * Servlet implementation class ServletAccueil
 */
//@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	ServicesAuthentification ser = new ServicesAuthentification();
	ServicesRecupDonnées recup = new ServicesRecupDonnées();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAccueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		boolean valid = ser.lireFichier(login, mdp);
		RequestDispatcher dispatcher;
		if(valid==false) {
			dispatcher = request.getRequestDispatcher("accueil.jsp?erreur=True");
			dispatcher.forward(request, response);
			
		}
		else {
			dispatcher = request.getRequestDispatcher("formulaire.jsp");
			dispatcher.forward(request, response);
			recup.initFichier();
			String donnee =recup.recupDonneesStagiaire(login, mdp);
			recup.ecrireFichier(donnee);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
