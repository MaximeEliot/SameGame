import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * La classe <code>MenuListener</code> est utilisée pour détecter les boutons du menu.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class MenuListener implements ActionListener{
	
	private JButton choisit;
    private JButton random;
    private char[][] grille;

    /**
     * constructeur de la classe MenuFinListener
     * @param choisitinit est le bouton d'initialisation prédéfini
     * @param randominit est le bouton d'initialisation random*/
    public MenuListener(JButton choisitinit,JButton randominit){
    	choisit = choisitinit;
    	random = randominit;
    }

	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==choisit) {
            
            JFileChooser filechooser = new JFileChooser();
            filechooser.setCurrentDirectory(new File("./Pattern/"));
            int reponse = filechooser.showOpenDialog(null);

            if (reponse == JFileChooser.APPROVE_OPTION) {
               grille = Choix.loadfile(filechooser.getSelectedFile().getAbsolutePath());
            }
        }
        if (e.getSource()==random) {
            grille = Choix.créerRandom();
        }
    }

    /**
     * methode pour récupérer la grille générée
     * @return une grille de char de 10 lignes et 15 collonnes */
    public char[][] getTab(){
    	return grille;
    }
}
