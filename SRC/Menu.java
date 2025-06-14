import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * La classe <code>Menu</code> est utilisée pour lancer le menu de choix d'initialisation.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class Menu{

    /**
     * methode de création de la fenêtre et d'affichage du menu
     * @return void*/
    public static void afficherMenu() {
        char[][] grille = new char[10][15];
        JFrame fenetre= new JFrame("Samegame");
        fenetre.getContentPane().removeAll();
        Dimension dim= new Dimension(350,200);
        GridLayout gestionnaire = new GridLayout(3, 1);
        JPanel ecran = new JPanel();
        JPanel presentation = new JPanel();
	    JPanel selection = new JPanel();
        JPanel boutons = new JPanel();
        JButton choisit = new JButton("Grille importée");
        JButton random = new JButton("Grille aléatoire");
        MenuListener listener = new MenuListener(choisit,random);
	
	    fenetre.setMinimumSize(dim);	
        ecran.setLayout(gestionnaire);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boutons.add(choisit);
        boutons.add(random);
        presentation.add(new JLabel("Bienvenue dans SAMEGAME !"));
	    presentation.add(new JLabel("Réalisé par Lucas POT et Maxime ELIOT"), BorderLayout.SOUTH);
	    selection.add(new JLabel("Sélectionnez la génération de la partie :"), BorderLayout.SOUTH);
        ecran.add(presentation);
	    ecran.add(selection);
        ecran.add(boutons);
        fenetre.add(ecran);

        choisit.addActionListener(listener);
        random.addActionListener(listener);
        

        ecran.revalidate();
        ecran.repaint();
        fenetre.setVisible(true);
        
        while (listener.getTab() == null) {
            try {
                Thread.sleep(500); // Attendre 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fenetre.dispose();

        Partie jeu = new Partie(listener.getTab());
        AfficheJeu.afficher(fenetre,jeu);
    }


}
