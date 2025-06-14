import javax.swing.*;
import java.awt.*;

/**
 * La classe <code>AfficheJeu</code> est utilisée pour l'affichage d'une partie.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class AfficheJeu extends JPanel {
    protected char[][] tabJeu;
    protected int score;
    protected int[][] tabBlock;

    /**
     * constructeur pour l'affichage d'un jeu
     * 
     * @param tabjeu le tableau du jeu 
     * @param jeu objet qui stocke le score
     * 
     */
    public AfficheJeu(char[][] tabJeu,Partie jeu) {
        this.tabJeu = tabJeu;
        this.score = jeu.getScore();
        this.tabBlock = new int[10][15];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int taillex = (getHeight() - 20) / 10;
        int tailley = getWidth()/15;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 15; y++) {
                switch(tabBlock[x][y]) {
                    case 0:
                        g.setColor(Color.LIGHT_GRAY);
                    break;
                    case 1:
                        g.setColor(Color.BLACK);
                        break;
                }
                g.fillRect(y * tailley, x * taillex, tailley, taillex);
                switch (tabJeu[x][y]) {
                    case 'R':
                        g.setColor(Color.RED);
                        break;
                    case 'V':
                        g.setColor(Color.GREEN);
                        break;
                    case 'B':
                        g.setColor(Color.BLUE);
                        break;
                    default:
                        g.setColor(Color.LIGHT_GRAY);
                        break;
                }
                g.fillOval(y * tailley, x * taillex, tailley, taillex);

            }
        }
        g.setColor(Color.BLACK);
        g.drawString(""+score,tailley,10*taillex+15);
    }

    /**
     * Methode static qui affiche le jeu et le gère
     * 
     * @param fenetre qui est la fenetre du jeu
     * @param jeu qui est l'objet d'une partie
     * 
     * @return void */
    public static void afficher(JFrame fenetre, Partie jeu) {
        PartieListener listenerClique = new PartieListener();
        fenetre.getContentPane().removeAll();
        fenetre.setSize(200, 300);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.addMouseListener(listenerClique);
        fenetre.addMouseMotionListener(listenerClique);

        AfficheJeu panel = new AfficheJeu(jeu.getTab(), jeu);

        fenetre.add(panel);
        fenetre.revalidate();
        fenetre.repaint();
        fenetre.setVisible(true);

        while (jeu.possibiliter()) {
            // Attente d'un clic
            panel.score = jeu.getScore();
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
            Insets insets = fenetre.getInsets();
            // Calcul de la taille des cases sans les marges
            int tailleCaseX = panel.getWidth()/ 15;
            int tailleCaseY = (panel.getHeight()-20)/ 10;
            if(listenerClique.getY()!=0){
                // Calcul des indices des colonnes et des lignes
                int colonne = listenerClique.getX() / tailleCaseX;
                int ligne = (listenerClique.getY()-insets.top) / tailleCaseY;
                // Vérification si les coordonnées sont dans les limites du tableau
                if (ligne >= 0 && ligne < 10 && colonne >= 0 && colonne < 15) {
                    jeu.remove(ligne, colonne);
                    panel.tabBlock = new int[10][15];
                } else {
                    System.out.println("Clic hors du tableau !");
                }
            }
            if (listenerClique.getXSurvole()!=0) {
            
                // Calcul des indices des colonnes et des lignes
                int colonne = (listenerClique.getXSurvole()-insets.right) / tailleCaseX;
                int ligne = (listenerClique.getYSurvole()-insets.top) / tailleCaseY;

                // Vérification si les coordonnées sont dans les limites du tableau
                if (ligne >= 0 && ligne < 10 && colonne >= 0 && colonne < 15) {
                    panel.tabBlock=jeu.testerBlock(ligne, colonne);
                }
            
            }
            listenerClique.resetClique();
            listenerClique.resetSurvole();
            panel.repaint();
            fenetre.revalidate();
        }
        fenetre.dispose();
        System.out.println("Score : "+panel.score);
        MenuFin.afficherMenu(fenetre,jeu.getScore()); 
    }

}



