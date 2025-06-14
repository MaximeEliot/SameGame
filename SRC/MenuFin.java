import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * La classe <code>MenuFin</code> est utilisée pour lancer le menu de fin.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class MenuFin{
    /**
     * methode static qui permet de choisir si on arrête ou recommence une partie
     * @param fenêtre qui est la fenêtre d'écran
     * @param score qui est le score de la dernière partie
     * 
     * @return void*/
    public static void afficherMenu(JFrame fenetre,int score) {
        fenetre.getContentPane().removeAll();
	    Dimension dim= new Dimension(350,200);
	    GridLayout gestionnaire = new GridLayout(3, 1);
        JPanel ecran = new JPanel();
        JPanel presentation = new JPanel();
	    JPanel selection = new JPanel();
        JPanel boutons = new JPanel();
        JButton rejouer = new JButton("rejouer");
        JButton quitter = new JButton("quitter");
        MenuFinListener listener = new MenuFinListener(rejouer,quitter);
	
	    fenetre.setMinimumSize(dim);	
        ecran.setLayout(gestionnaire);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boutons.add(rejouer);
        boutons.add(quitter);
        presentation.add(new JLabel("Vôtre score est de : "+score));
	    selection.add(new JLabel("Sélectionnez votre choix :"), BorderLayout.SOUTH);
        ecran.add(presentation);
	    ecran.add(selection);
        ecran.add(boutons);
        fenetre.add(ecran);

        rejouer.addActionListener(listener);
        quitter.addActionListener(listener);
        

        ecran.revalidate();
        ecran.repaint();
        fenetre.setVisible(true);
        
        while (listener.get() == 0) {
        try {
            Thread.sleep(500); // Attendre 500 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        switch (listener.get()){
        case 1: 
            fenetre.dispose();
            Menu.afficherMenu();
            
        break;
        case 2: 
            fenetre.dispose();
        break;
        }

    }


}
