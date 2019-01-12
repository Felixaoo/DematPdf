package afpa.fr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afpa.fr.service.ServicesRecupDonnées;

/**
 * Servlet implementation class Servlet5
 */
//@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesRecupDonnées recup = new ServicesRecupDonnées();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String locaux = request.getParameter("locaux");
		String taille = request.getParameter("taille");
		String mat = request.getParameter("mat");
		recup.ecrireFichier(locaux);
		recup.ecrireFichier(taille);
		recup.ecrireFichier(mat);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("jsp6.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
