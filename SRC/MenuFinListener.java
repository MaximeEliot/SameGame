import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>MenuFinListener</code> est utilisée pour détecter les boutons du menu de fin.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class MenuFinListener implements ActionListener{
	
	private JButton rejouer;
    private JButton quitter;
    private int choix;

    /**
     * constructeur de la classe MenuFinListener
     * @param rejouer qui est le bouton rejouer
     * @param quitter qui est le bouton quitter*/
    public MenuFinListener(JButton rejouer,JButton quitter){
    	this.rejouer = rejouer;
    	this.quitter = quitter;
    }
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rejouer) {
            choix=1;

        }
        if (e.getSource()==quitter) {
            choix=2;
        }
    }
    /**
     * methode pour récupérer le choix effectuer
     * @return int qui est le choix effectuer*/
    public int get(){
    	return choix;
    }
}
