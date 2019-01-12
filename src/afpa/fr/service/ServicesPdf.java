package afpa.fr.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import afpa.util.entity.CreationPDF;
public class ServicesPdf {


	public void impressionPDF(CreationPDF c) throws DocumentException, URISyntaxException, IOException {
		Document document = new Document(PageSize.A4, 7, 7, 7, 7);
		PdfWriter.getInstance(document, new FileOutputStream("c:\\test\\formulaire.pdf"));
		document.open();
		Image img = Image.getInstance("C:\\Test\\pole_emploi.png");
		img.scalePercent(20);
		Font font = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
		Chunk chunkBlank = new Chunk(" ");
		Paragraph para = new Paragraph("Action de formation collective Pôle emploi (AFC)", font);
		Paragraph para2 = new Paragraph("Fiche individuelle de formation ", font);
		Paragraph para3 = new Paragraph("          Evaluation de la formation : entourer la case de votre choix pour chaque ligne");
		float []taille = {2f, 0.8f, 0.8f, 0.8f, 0.8f}; // 5 paramètres pour 5 colonnes !
		PdfPTable table = new PdfPTable(2); //  2 colonnes
		PdfPTable table2 = new PdfPTable(taille); // 5 colonnes du coup
		PdfPTable tableCom = new PdfPTable(1); // 1 colonne
		float []taille2 = {0.5f, 4f};
		PdfPTable tableTitre = new PdfPTable(taille2);
		//addTableHeader(table);
		//addRows(tableTitre);
		addRows(table);
		addRows2(table2, c);
		addRowCom(tableCom, c);
		//addCustomRows(table);
		document.add(img);
		document.add(tableTitre);
		document.add(para);
		document.add(para2);
		document.add(chunkBlank);
		
		document.add(table);
		document.add(chunkBlank);
		document.add(para3);
		document.add(chunkBlank);
		document.add(table2);
		document.add(tableCom);
		document.close();
	}
	/*
    private static void addTableHeader(PdfPTable table) {
        Stream.of("column header 1", "column header 2")
        .forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            //header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(0);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }*/ 
	private static  void addRows(PdfPTable table) throws IOException {
		String id="";
		FileReader fr=new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\Stagiaires.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String[]tab=br.readLine().split(";");
			id=tab[0];
		}
		table.addCell("Date "+ LocalDate.now());
		table.addCell("Nom, prénom du stagiaire: " + recupNom(id)+ ",  " + recuppreNom(id) );
		table.addCell("Organisme responsable du stage: AFPA Roubaix");
		table.addCell("Intitulé de l'action de formation: 18389 - IDP JAVA JEE 26/11/2018 AU 15/01/2019");
	}



	private static  void addRows2(PdfPTable table, CreationPDF c) throws IOException {
		String[]avis =recupAvis();
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		addCellColor("I - CONTENU DU STAGE EN CENTRE DE FORMATION", table);
		addCellColor("Insatisfaisant ou inadapté",table);
		addCellColor("Peu satisfaisant",table);
		addCellColor("Satisfaisant",table);
		addCellColor("Très Satisfaisant",table);
		table.addCell("Duréee totale du stage");
		addCheckedCells(table,c, avis[4]);
		table.addCell("programme du stage");
		addCheckedCells(table, c,  avis[5]);
		table.addCell("Apport de connaissances théoriques:");
		addCheckedCells(table, c, avis[6]);
		table.addCell("Apport de connaissances pratiques:");
		addCheckedCells(table, c, avis[7]);
		table.addCell("Adéquation avec l'objectif inital de la formation:");
		addCheckedCells(table, c,avis[8]);
		addCellColor("II - CONTENU DU STAGE EN ENTREPRISE (si vous avez suivi un stage en entreprise",table);
		addCellColor("Insatisfaisant ou inadapté",table);
		addCellColor("Peu satisfaisant",table);
		addCellColor("Satisfaisant",table);
		addCellColor("Très Satisfaisant",table);
		table.addCell("Application pratique en entreprise correspondant aux acquisition en centre de formation");
		addCheckedCells(table, c, avis[9]);
		table.addCell("Suivi du stage en entreprise:");
		addCheckedCells(table,c, avis[10]);
		addCellColor("III - ANIMATION",table);
		addCellColor("Insatisfaisant ou inadapté",table);
		addCellColor("Peu satisfaisant",table);
		addCellColor("Satisfaisant",table);
		addCellColor("Très Satisfaisant",table);
		table.addCell("Adaptation du contenu:");
		addCheckedCells(table, c, avis[11]);
		table.addCell("Méthode pédagogique mobilisée:");
		addCheckedCells(table, c, avis[12]);
		table.addCell("Disponibilité et réponse aux attentes:");
		addCheckedCells(table, c, avis[13]);
		table.addCell("Supports utilisés:");
		addCheckedCells(table, c, avis[14]);
		table.addCell("Interactions dans le groupe, vie de groupe::");
		addCheckedCells(table, c, avis[15]);
		addCellColor("IV - DOCUMENTATION",table);
		addCellColor("Insatisfaisant ou inadapté",table);
		addCellColor("Peu satisfaisant",table);
		addCellColor("Satisfaisant",table);
		addCellColor("Très Satisfaisant",table);
		table.addCell("documentation remise:");
		addCheckedCells(table, c, avis[16]);
		addCellColor("V - CONDITIONS MATERIELLES",table);
		addCellColor("Insatisfaisant ou inadapté",table);
		addCellColor("Peu satisfaisant",table);
		addCellColor("Satisfaisant",table);
		addCellColor("Très Satisfaisant",table);
		table.addCell("Locaux:");
		addCheckedCells(table,c, avis[17]);
		table.addCell("Taille du groupe satisfaisant:");
		addCheckedCells(table, c, avis[18]);
		table.addCell("Matériel à disposition:");
		addCheckedCells(table, c, avis[19]);
		addCellColor("VI - APPRECIATION GLOBALE",table);
		addCellColor("Insatisfaisant ou inadapté",table);
		addCellColor("Peu satisfaisant",table);
		addCellColor("Satisfaisant",table);
		addCellColor("Très Satisfaisant",table);
		table.addCell("Avis global sur la formation:");
		addCheckedCells(table, c, avis[20]);

	}

	private static void addCheckedCells(PdfPTable table, CreationPDF c, String item) {
		for (int i=0; i < 4; i++) {
			if (i == 0 && item.equals("--")) {
				table.addCell("X");
			}
			else if (i == 1 && item.equals("-")) {
				table.addCell("X");
			}
			else if (i == 2 && item.equals("+")) {
				table.addCell("X");
			}
			else if (i == 3 && item.equals("++")) {
				table.addCell("X");
			}
			else {
				table.addCell("");
			}
		}
	}
	public static void addCellColor(String text,PdfPTable table) {
	       
        Font font2 = FontFactory.getFont(FontFactory.COURIER_BOLD ,10, BaseColor.BLACK);
       PdfPCell  cell = new PdfPCell(new Phrase(text,font2));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(new BaseColor(42,177,222));
       table.addCell(cell);
      
   }
	private static  void addRowCom(PdfPTable table, CreationPDF c) throws IOException {
		table.addCell("Commentaires: " + recupCom());
	}


	/*
    private static void addCustomRows(PdfPTable table)
            throws URISyntaxException, BadElementException, IOException {
        //  Path path = Paths.get(ClassLoader.getSystemResource("c:\\test\\Java_logo.png").toURI());
        //  Image img = Image.getInstance(path.toAbsolutePath().toString());
        //   img.scalePercent(10);
        //    PdfPCell imageCell = new PdfPCell(img);
        //    table.addCell(imageCell);
        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(horizontalAlignCell);
        PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(verticalAlignCell);
    }*/
	public static String recupNom(String id) throws IOException {
		String Nom="";
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String []tab=br.readLine().split(";");
			if(tab[0].equals(id)) {Nom=tab[1];}
		}
		br.close();
		return Nom;
	}
	public static String recuppreNom(String id) throws IOException {
		String preNom="";
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String []tab=br.readLine().split(";");
			if(tab[0].equals(id)) {
				preNom=tab[2];
			}
		}
		br.close();
		return preNom;
	}

	public static String [] recupAvis() throws IOException {
		String [] tab= new String[23];
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\stagiaires.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			tab=br.readLine().split(";");
		}
		br.close();
		return tab;
	}


	public static String recupCom() throws IOException {
		String com="";
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\commentaire");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			com+=br.readLine();
		}
		br.close();
		return com;
	}


}
