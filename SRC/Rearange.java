import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>Rearange</code> est utilisée pour rearanger le tableau.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class Rearange{

    /**
     * méthode static qui s'occupe de la gravité et de ramener vers la gauche
     * 
     * @param tab la grille actuelle de la partie
     * 
     * @return rien car modifie directement le tableau donné
     */
    public static void rearanger(char[][] tab) {
    int x, y;
    boolean modif;

    // **1. Appliquer la gravité (Faire tomber les blocs)**
    do {
        modif = false;
        for (x = 1; x < 10; x++) {
            for (y = 0; y < 15; y++) {
                if (tab[x][y] == '\0' && tab[x - 1][y] != '\0') { 
                    tab[x][y] = tab[x - 1][y]; 
                    tab[x - 1][y] = '\0';
                    modif = true;
                }
            }
        }
    } while (modif); 
    decalerGauche(tab);
    }


    /**
     * méthode static qui s'occupe de ramener vers la gauche
     * 
     * @param tab la grille actuelle de la partie
     * 
     * @return rien car modifie directement le tableau donné
     */
    public static void decalerGauche(char[][] tab) {
        int nbColonnes = tab[0].length;
        int nbLignes = tab.length;

        int destination = 0; // Colonne où déplacer les données

        for (int y = 0; y < nbColonnes; y++) {
            boolean colonneVide = true;
            
            // Vérifier si la colonne actuelle est vide
            for (int x = 0; x < nbLignes; x++) {
                if (tab[x][y] != '\0') {
                    colonneVide = false;
                    break;
                }
            }

            // Si la colonne n'est pas vide, on la déplace vers la gauche à la position "destination"
            if (!colonneVide) {
                if (destination != y) { // Évite de déplacer une colonne sur elle-même
                    for (int x = 0; x < nbLignes; x++) {
                        tab[x][destination] = tab[x][y];  // Déplacer
                        tab[x][y] = '\0';                 // Vider l'ancienne colonne
                    }
                }
                destination++; // Prochaine position de colonne non vide
            }
        }
    }



}
