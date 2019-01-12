package afpa.fr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afpa.fr.service.ServicesMail;
import afpa.fr.service.ServicesRecupDonnées;

/**
 * Servlet implementation class ServletCommentaire
 */
//@WebServlet("/ServletCommentaire")
public class ServletCommentaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesRecupDonnées recup = new ServicesRecupDonnées();
	ServicesMail servMail= new ServicesMail();
	public static int code;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCommentaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String commentaire = request.getParameter("commentaire");
		recup.ecrireCom(commentaire);
		RequestDispatcher dispatcher;
		code = servMail.GenererCode();
		String adresseMail = servMail.recupAdresse();
		String objet = "Code Pole Emploi";
		String body = " Voici le code a rentrer afin de signer electroniquement votre formulaire :"+code;
		try {
			servMail.sendMail(adresseMail, objet, body);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher = request.getRequestDispatcher("mail.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
