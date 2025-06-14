/**
 * La classe <code>Partie</code> est utilisée pour désigner l'ensemble d'une partie.
 *  
 * @version 1.1
 * @author Lucas POT & Maxime ELIOT
 */
public class Partie {
    /**
     * variable de stockage du score
     */
    private int score;
    private char[][] tabJeu;

    /**
     * constructeur destiné à la création d'une partie
     * @param tabjeu la table d'initialisaton de la partie
    */
    public Partie(char[][]tabJeu){
        this.score = 0;
        this.tabJeu = tabJeu;
    }

    /**
     * méthode qui trouve le block le plus grand qui existe
     * 
     * @param x les coordonnées en x (entre 0 et 10)
     * @param y les coordonnées en y (entre 0 et 15)
     * 
     * @return un tableau avec des 1 pour toutes les cases constituants le block
     */
public int[][] testerBlock(int x, int y) {
    int[][] tabBlock = new int[10][15];
    int test=0;
    char choix = tabJeu[x][y];
    if (choix == '\0') {
        return tabBlock; // Retourne directement si le choix est vide
    }

    tabBlock[x][y] = 1;
    boolean go_on = true;

    while (go_on) {
        go_on = false;
        for (int ligne = 0; ligne < 10; ligne++) {
            for (int collone = 0; collone < 15; collone++) {
                if (tabJeu[ligne][collone] == choix && tabBlock[ligne][collone] == 0) {
                    boolean voisinTrouve = false;

                    // Vérification des voisins
                    for (int direction = 0; direction < 4; direction++) {
                        int newLigne = ligne, newCollone = collone;
                        switch (direction) {
                            case 0: newLigne = ligne - 1; break; // Haut
                            case 1: newLigne = ligne + 1; break; // Bas
                            case 2: newCollone = collone - 1; break; // Gauche
                            case 3: newCollone = collone + 1; break; // Droite
                        }

                        // Vérifier si la cellule voisine est valide et déjà bloquée
                        if (newLigne >= 0 && newLigne < 10 && newCollone >= 0 && newCollone < 15) {
                            if (tabBlock[newLigne][newCollone] == 1) {
                                voisinTrouve = true;
                                break;
                            }
                        }
                    }

                    if (voisinTrouve) {
                        tabBlock[ligne][collone] = 1;
                        test++;
                        go_on = true;
                    }
                }
            }
        }
    }
    if(test!=0){return tabBlock;}
    else{return new int[10][15];}
    }


    /**
     * méthode permettant de supprimer un block
     * @param x les coordonnées en x (entre 0 et 10)
     * @param y les coordonnées en y (entre 0 et 15)
     * 
     * @return rien car modifie directement le tableau donné
     */
    public void remove(int x,int y){

        int[][] tabBlock= testerBlock(x, y);
        int qttrm=0;
        for(int ligne=0;ligne<10;ligne++){
            for(int collone=0;collone<15;collone++){
                if(tabBlock[ligne][collone]==1){
                    qttrm++;
                }
            }
        }
        if(qttrm>=2){
            for(int ligne=0;ligne<10;ligne++){
                for(int collone=0;collone<15;collone++){
                    if(tabBlock[ligne][collone]==1){
                        tabJeu[ligne][collone]='\0';
                    }
                }
            }
        }
        else{return;}
        Rearange.rearanger(tabJeu);
        score+=(qttrm-2)*(qttrm-2);

    
    }


    /**
     * Renvoie le score actuel de la partie
     *
     * @return le score en int
     */ 
    public int getScore(){
        return score;
    }


    /**
     * Méthode pour vérifier si il existe encore des possibilités de destruction
     * 
     * 
     * @return boolean true si il en reste et false si c'est fini
     */
    public boolean possibiliter(){
        int collone=0,temp=0;

        for(int ligne=0;ligne<10;ligne++){
            for(collone=collone%15;collone<15;collone+=2){
                int[][] tabBlock= testerBlock(ligne, collone);
                for(int x=0;x<10;x++){
                    for(int y=0;y<15;y++){
                        if(tabBlock[x][y]==1){
                            temp++;
                        }
                    }
                }
                if (temp>=2) {
                    return true;  
                }
                else{
                    temp=0;
                }
            }
        }
        return false;
    }

    public char[][] getTab(){
        return tabJeu;
    }
}
