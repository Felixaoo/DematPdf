package afpa.fr.servlet;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import afpa.fr.service.ServicesMail;
import afpa.fr.service.ServicesPdf;
import afpa.fr.service.ServicesRecupDonnées;
import afpa.util.entity.CreationPDF;

/**
 * Servlet implementation class ServletMail
 */
//@WebServlet("/ServletMail")
public class ServletMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesRecupDonnées recup = new ServicesRecupDonnées();
	ServicesPdf pdf = new ServicesPdf ();
	ServicesMail mail= new ServicesMail();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeRecup = request.getParameter("code");
		int codeRecupInt=Integer.parseInt(codeRecup);
		RequestDispatcher dispatcher;
		CreationPDF c=new CreationPDF();
		String adresse = mail.recupAdresse();
		if(codeRecupInt==ServletCommentaire.code) {
			try {
				pdf.impressionPDF(c);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				mail.sendMail2(adresse, "PDF formulaire pole emploi", "voici le pdf résumant vos réponses au questionnaire");
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recup.majid();
			dispatcher = request.getRequestDispatcher("merci.jsp");
			dispatcher.forward(request, response);	
		}
		else {
			dispatcher = request.getRequestDispatcher("mail.jsp?erreur=True");
			dispatcher.forward(request, response);
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
