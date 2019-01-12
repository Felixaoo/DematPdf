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
 * Servlet implementation class Servlet3
 */
//@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesRecupDonnées recup = new ServicesRecupDonnées();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adaptation = request.getParameter("adaptation");
		String methode = request.getParameter("methode");
		String dispo = request.getParameter("dispo");
		String supports = request.getParameter("supports");
		String inter = request.getParameter("inter");
		
		recup.ecrireFichier(adaptation);
		recup.ecrireFichier(methode);
		recup.ecrireFichier(dispo);
		recup.ecrireFichier(supports);
		recup.ecrireFichier(inter);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("jsp4.jsp");
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
