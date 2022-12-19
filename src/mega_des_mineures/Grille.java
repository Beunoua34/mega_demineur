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
    private int nb_cases;

    public int getNb_drapeaux() {
        return nb_drapeaux;
    }

    public void setNb_drapeaux(int nb_drapeaux) {
        this.nb_drapeaux = nb_drapeaux;
    }

    public Grille(int difficulte) {
        if (difficulte == 1) {
            this.grille = new Cellule[10][10];
            nb_cases = 10;
        } else if (difficulte == 2) {
            this.grille = new Cellule[20][20];
            nb_cases = 20;
        } else if (difficulte == 3) {
            this.grille = new Cellule[30][30];
            nb_cases = 30;
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
        for (int i = 0; i < nb_cases; i++) {
            for (int j = 0; j < nb_cases; j++) {
                if (grille[i][j].PresenceBombe()) {
                    if (grille[i][j].PresenceDrapeau() == false) {
                        win = false;
                    }
                }
            }

        }
        return win;
    }

}
