import javax.swing.*;
import java.awt.*;
import java.util.*; 
import java.io.*;
import java.lang.*;

/**
 * La classe <code>Choix</code> est utilisée pour récupérer le choix de créaction d'une partie et générer son tableau.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class Choix {

	/**
	 * methode static qui créé un tableau random
	 * 
	 * @return le tableau pour la partie*/
	public static char[][] créerRandom(){
		char[][] tab = new char[10][15];
		Random rnd = new Random();

		for(int x=0;x<10;x++){
			for(int y=0;y<15;y++){
				int random = rnd.nextInt(3); 
				switch (random){
					case 0:tab[x][y]='R';break;
					case 1:tab[x][y]='V';break;
					case 2:tab[x][y]='B';break;
					}
			}
		}
		return tab;
	}

	/**
	 * methode static permettant de charger un tableau à partir d'un fichier
	 * 
	 * @param filename qui est le nom du fichier selectionné
	 * @return le tableau générer*/
	public static char[][] loadfile(String filename){
		char[][] result = new char[10][15];
		try {
			BufferedReader entree = new BufferedReader(new FileReader(filename));
			try{
				String line = entree.readLine();
        		if(line != null) {
          			int temp=0,temp2=0;
          			while((line) != null && temp2<10) {
          				char[] tempchar = line.toCharArray();
            				for(temp=0;temp<15;temp++){
					    if((tempchar[temp]=='R')|(tempchar[temp]=='V')|(tempchar[temp]=='B')){
          						result[temp2][temp]=tempchar[temp];
          					}
          					else {
          						System.err.println("le format du fichier ne correspond pas à une partie");
          					}
          				}
          				temp2++;
					line = entree.readLine();
          			}
        		} 
        		else {
          		System.err.println("Fichier vide.");
        		}
        	} 
        	catch(IOException e) {
        		System.out.println("Erreur de lecture");
      		} 
     		try {
        		entree.close();
      		} 
      		catch(IOException e) {
       			System.err.println("Erreur de fermeture.");
      		}
    	} 
    	catch(FileNotFoundException e) {
      		System.err.println("Erreur d'ouverture");
    	}
    	return result;
	}
}
