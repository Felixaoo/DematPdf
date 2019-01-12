package afpa.fr.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServicesAuthentification {

	public boolean lireFichier(String login, String mdp) throws IOException {
		boolean exist=false;
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String []tab=br.readLine().split(";");
			if(login.equals(tab[3])&&mdp.equals(tab[4])) {
				exist=true;
				br.close();
				return exist;
			}
		}
		br.close();
		return exist;
	}
	
	public String recupId() throws IOException {
		String listId="";
		FileReader fr = new FileReader("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\personne.csv");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String []tab=br.readLine().split(";");
			listId+=tab[0]+";";
		}
		br.close();
		return listId;
	}
	
	public void ecrireFichier(String input) throws IOException {
		FileWriter fw = new FileWriter("C:\\ENV\\WORKSPACE_JEE\\idp_jee_fg\\Stagiaires.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(input+";");
		bw.close();
		
	}

}
