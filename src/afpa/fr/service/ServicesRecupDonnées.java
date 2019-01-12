package afpa.fr.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServicesRecupDonnées {

	public void initFichier() throws IOException {
		FileWriter fw = new FileWriter("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\Stagiaires.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.close();
	}

	public void ecrireFichier(String input) throws IOException {
		FileWriter fw = new FileWriter("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\Stagiaires.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(input+";");
		bw.close();
	}
		public void ecrireCom(String com) throws IOException {
			
			FileWriter fw = new FileWriter("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\commentaire");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(com);
			bw.close();
					
		}
		
		
	

	public String recupDonneesStagiaire(String login, String mdp) throws IOException {
		String donneesStagiaire="";
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String []tab=br.readLine().split(";");
			if(login.equals(tab[3])&&mdp.equals(tab[4])) {
				donneesStagiaire+=tab[0]+";"+tab[1]+";"+tab[2]+";"+tab[3];
				
				
			}
			
		}
		br.close();
		return donneesStagiaire;
	}
	
	
		public void majid() throws IOException {

		       FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\Stagiaires.txt");
		       BufferedReader  br= new BufferedReader(fr);
		       String[] id=br.readLine().split(";");
		       String idverif=id[0];
		       br.close();
		       FileReader entree = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
		       FileWriter sortie = new FileWriter("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\temp.csv");
		       BufferedReader br2 = new BufferedReader(entree);
		       BufferedWriter bw = new BufferedWriter(sortie);
		       String[] elements=null;
		       while (br2.ready()){
		       elements=br2.readLine().split(";");
		        if(elements[0].equals(idverif)){
		            bw.write(elements[0]+";"+elements[1]+";"+elements[2]+";"+elements[3]+";"+elements[4]+";"+"true");
		            bw.newLine();
		        }else{
		            bw.write(elements[0]+";"+elements[1]+";"+elements[2]+";"+elements[3]+";"+elements[4]+";"+elements[5]);
		            bw.newLine();
		        }

		       }
		       bw.close();
		       br2.close();



		       File file   = new File("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");

		       file.delete();

		       File file2  = new File("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");

		       

		       File file3 = new File("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\temp.csv");

		       file3.renameTo(file2);
		       



		   }
		public void fomulaireValide(String adresseMail) throws IOException {
			int compteur=0;
			FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				compteur++;
				System.out.println(compteur);
			}
			br.close();
			System.out.println("testing :"+compteur);
			while(br.ready()) {
				String[]tab=br.readLine().split(";");
				FileWriter fw = new FileWriter("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne2.csv");
				BufferedWriter bw= new BufferedWriter(fw);
					for(int i=0; i<compteur; i++) {
						if(adresseMail.equals(tab[3])) {
						bw.write(tab[0]+";"+tab[1]+";"+tab[2]+";"+tab[3]+";"+tab[4]+";"+"validé");
						bw.newLine();
						}
						else {
							bw.write(tab[0]+";"+tab[1]+";"+tab[2]+";"+tab[3]+";"+tab[4]+";"+tab[5]);
							bw.newLine();
						}
							
					}
					bw.close();
				}
			br.close();
			
			}
	}
