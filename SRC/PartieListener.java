import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>PartieListener</code> est utilisée pour désigner l'ensemble d'une partie.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class PartieListener implements MouseListener, MouseMotionListener {
    private int y;
    private int x;
    private int ysurvol;
    private int xsurvol;

    @Override
    public void mousePressed(MouseEvent e) {
        y = e.getY();
        x = e.getX();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        ysurvol = e.getY();
        xsurvol = e.getX();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    /**
     * méthode pour récupérer le x actuel de la souris
     * @return la position en x*/
    public int getX() {
        return x;
    }

    /**
     * méthode pour récupérer le y actuel de la souris
     * @return la position en y*/
    public int getY() {
        return y;
    }

    /**
     * méthode pour reset les valeurs de x et y de quand la souris clique*/
    public void resetClique() {
        y=0;
        x=0;
    }

    /**
     * methode pour récupérer le x actuel de la souris quand elle a cliqué
     * @return la position en x*/
    public int getXSurvole(){
        return xsurvol;
    }

    /**
     * méthode pour récupérer le y actuel de la souris quand elle a cliqué
     * @return la position en y*/
    public int getYSurvole(){
        return ysurvol;
    }

    /**
     * méthode pour reset les valeurs de x et y de quand la souris survole une case*/
    public void resetSurvole(){
        ysurvol=0;
        xsurvol=0;
    }
}
