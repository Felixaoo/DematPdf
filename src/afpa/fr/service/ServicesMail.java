package afpa.fr.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class ServicesMail {
	
	public String recupAdresse() throws IOException {
		String mail="";
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\Stagiaires.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String []tab=br.readLine().split(";");
			mail=tab[3];
		}
		br.close();
		return mail;
	}
	
	public void sendMail(String adresse, String objet, String body) throws Throwable, Exception {
		String from = "idpjava2019@gmail.com";
		String password = "@Afpa2019";
		String to = adresse;

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(objet);
		//message.setText("Bonjour, vous trouverez en pièce jointe la facture de Caisse du " + fileCreatedName.substring(27, 35));


		Multipart multipart = new MimeMultipart();       
		BodyPart messageBodyPart = new MimeBodyPart();     
		messageBodyPart.setText(body);
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);




		Transport.send(message);
	}
	
	public void sendMail2(String adresse, String objet, String body) throws Throwable, Exception {
		String from = "idpjava2019@gmail.com";
		String password = "@Afpa2019";
		String to = adresse;

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(objet);
		//message.setText("Bonjour, vous trouverez en pièce jointe la facture de Caisse du " + fileCreatedName.substring(27, 35));
		MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();
	
		messageBodyPart = new MimeBodyPart();
	       DataSource source = new FileDataSource("c:\\test\\formulaire.pdf"); // ici l'adresse complète du fichier
	       messageBodyPart.setDataHandler(new DataHandler(source));
	       messageBodyPart.setFileName("formulaire.pdf"); // ici le nom que je veux donner au fichier
	       multipart.addBodyPart(messageBodyPart);
	       message.setContent(multipart);

		Transport.send(message);
	}
	
	public int GenererCode() {
		int code =(int)( Math.random()*( 999999 - 100000 + 1 ) ) + 100000;
		return code;
	}
	public static void envoieMail(String mail, String chemin) throws AddressException, MessagingException {

        LocalDateTime currentTime = LocalDateTime.now();

        int mois = currentTime.getMonthValue();
        int jour = currentTime.getDayOfMonth();
        int heure = currentTime.getHour();
        int minute = currentTime.getMinute();

        int annee = currentTime.getYear();

        String dateheure = Integer.toString(annee) + Integer.toString(mois) + Integer.toString(jour)
                + Integer.toString(heure) + Integer.toString(minute);

        File file = new File(chemin);

        String from = "idpjava2019@gmail.com";
		String password = "@Afpa2019";
		String to = mail;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Votre ticket pour le" + Integer.toString(mois) + Integer.toString(jour));

        // Première partie du message
        MimeBodyPart messageBodyPart = new MimeBodyPart();

        // Ajout de la première partie du message dans un objet Multipart
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Contenu du message

        String texte = "<H1>" + "Formulaire POle Emploi " + "</H1>";
        messageBodyPart.setContent(texte, "text/html");

        // Partie de la pièce jointe
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("Formulaire Pole emploi" + dateheure);

        // Ajout de la partie pièce jointe
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

        Transport.send(message);
    }
}
