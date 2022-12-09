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

    public Grille(int difficulte) {
        if (difficulte==1){
            this.grille=new Cellule[25][25];
        }
        else if (difficulte==2){
            this.grille=new Cellule[50][50];
        } else if (difficulte==3){
            this.grille=new Cellule[100][100];
        }
    }
    public int nbBombesAutour(int ligne, int col){
        int nb_bombes=0;
        int taille=grille.length;
        if (ligne==0){ //si on est sur la ligne du bas
            if (col==0){ //si on est dans le coin inferieur gauche
                if (grille[ligne+1][col].PresenceBombe()) nb_bombes+=1; //case au dessus
                if (grille[ligne+1][col+1].PresenceBombe()) nb_bombes+=1;   //case superieur droite
                if (grille[ligne][col+1].PresenceBombe()) nb_bombes+=1; //case a droite
                return nb_bombes;                  
            } else if (col==taille){ //si on est dans le coin inferieur droit
                if (grille[ligne+1][col].PresenceBombe()) nb_bombes+=1; //case au dessus
                if (grille[ligne][col-1].PresenceBombe()) nb_bombes+=1; //case a gauche 
                if (grille[1][taille].PresenceBombe()) nb_bombes+=1;
            } else {//si on est pas dans un coin
                if (grille[-1][0].PresenceBombe()) nb_bombes+=1;
                if (grille[taille-1][taille-1].PresenceBombe()) nb_bombes+=1;   
                if (grille[0][taille-1].PresenceBombe()) nb_bombes+=1;
                if (grille[1][1].PresenceBombe()) nb_bombes+=1;   
                if (grille[0][1].PresenceBombe()) nb_bombes+=1;
            }
            
        }
        return nb_bombes;
    }
    
       
}

