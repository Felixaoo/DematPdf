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
 * Servlet implementation class Servlet1
 */
//@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesRecupDonnées recup = new ServicesRecupDonnées();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String duree = request.getParameter("duree");
		String programme = request.getParameter("Programme");
		String apport = request.getParameter("Apport");
		String pratiques = request.getParameter("pratiques");
		String adequation = request.getParameter("Adéquation");
		recup.ecrireFichier(duree);
		recup.ecrireFichier(programme);
		recup.ecrireFichier(apport);
		recup.ecrireFichier(pratiques);
		recup.ecrireFichier(adequation);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("jsp2.jsp");
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
