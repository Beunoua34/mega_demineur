/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mega_des_mineures;

/**
 *
 * @author benba
 */
public class Grille {

    Cellule[][] grille; //on declare un niveau de difficulte allant de 1 a 3 et une grille dont la taille depend de la difficulte
    private int nb_drapeaux;
    private int life =1; //nombre de vie restantes au joueur

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    

    private boolean premierCoup = true;//on ne peut pas perdre des le premier coup, on le note dans un booleen
    private boolean partieFinie=false;//variable qui prendra true a la fin de la partie

    public void setPartieFinie(boolean partieFinie) {
        this.partieFinie = partieFinie;
    }

    public boolean isPartieFinie() {
        return partieFinie;
    }
    
    public int getNb_drapeaux() {
        return nb_drapeaux;
    }

    public boolean isPremierCoup() {
        return premierCoup;
    }

    public void setPremierCoup(boolean premierCoup) {
        this.premierCoup = premierCoup;
    }

    public void setNb_drapeaux(int nb_drapeaux) {
        this.nb_drapeaux = nb_drapeaux;
    }

    public Grille(int difficulte) {
        if (difficulte == 1) {
            this.grille = new Cellule[10][10];

        } else if (difficulte == 2) {
            this.grille = new Cellule[20][20];

        } else if (difficulte == 3) {
            this.grille = new Cellule[30][30];

        }
    }

    public int nbBombesAutour(int ligne, int col) {
        int nb_bombes = 0;
        int taille = grille.length;
        for (int i = ligne - 1; i <= ligne + 1; i++) {
            if (i < 0) {
                i++;
            }
            if (i >= taille) {
                break;
            }
            for (int j = col - 1; j <= col + 1; j++) {
                if (j < 0) {
                    j++;
                }
                if (j >= taille) {
                    break;
                }
                if (grille[i][j].PresenceBombe()) {
                    nb_bombes++;
                }
            }
        }

        return nb_bombes;
    }

    public boolean partieGagnante() {
        boolean win = true; //on part du principe que la partie est gagnante, et on cherche une  bombe non marquee par un drapeau
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                if (grille[i][j].PresenceBombe()) {
                    if (grille[i][j].PresenceDrapeau() == false) {
                        win = false;
                    }
                }
            }

        }
        return win;
    }

    public int enleverBombesPremierCoup() {
        int bombes_enlevees = 0;
        for (int ligne = 0; ligne < grille.length; ligne++) {
            for (int col = 0; col < grille.length; col++) {
                if (grille[ligne][col].isCache() == false) {
                    for (int i = ligne - 1; i <= ligne + 1; i++) {
                        if (i < 0) {
                            i++;
                        }
                        if (i >= grille.length) {
                            break;
                        }
                        for (int j = col - 1; j <= col + 1; j++) {
                            if (j < 0) {
                                j++;
                            }
                            if (j >= grille.length) {
                                break;
                            }
                            if (grille[i][j].PresenceBombe()) {
                                grille[i][j].enleverBombe();
                                bombes_enlevees += 1;
                            }

                        }
                    }
                }
            }
        }
        for (int ligne = 0; ligne < grille.length; ligne++) {
            for (int col = 0; col < grille.length; col++) {
                grille[ligne][col].setBombeAutour(nbBombesAutour(ligne, col));
            }
        }

        return bombes_enlevees;
    }

    public void demasquerCasesAutour(int ligne, int col) {

        for (int i = ligne - 1; i <= ligne + 1; i++) {
            if (i < 0) {
                i++;
            }
            if (i >= grille.length) {
                break;
            }
            for (int j = col - 1; j <= col + 1; j++) {
                if (j < 0) {
                    j++;
                }
                if (j >= grille.length) {
                    break;
                }
                grille[i][j].setCache(false);

            }
        }
    }

    public void demasquerCases() {
        for (int k = 0; k < grille.length; k++) { //on repete plusieurs fois l'action pour traiter toutes les cases
            for (int i = 0; i < grille.length; i++) {
                for (int j = 0; j < grille.length; j++) {
                    if (grille[i][j].isCache() == false) {
                        if (grille[i][j].getBombeAutour() == 0) {

                            demasquerCasesAutour(i, j);
                        }
                    }
                }
            }
        }
    }
    public void demasquerBombes(){//en fin de partie, on utlisera cette fonctions pour montrer ou etaient les bombes
        for (int i = 0; i < grille.length; i++) {
                for (int j = 0; j < grille.length; j++) {
                    if (grille[i][j].PresenceBombe()){
                        grille[i][j].setCache(false);
                    }
                }
    }

}
}
