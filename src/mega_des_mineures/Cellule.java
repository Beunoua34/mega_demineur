/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mega_des_mineures;

/**
 *
 * @author benba
 */
public class Cellule {

    private int alea;

    public Cellule() {
    }
    private boolean presenceBombe = false;
    private int bombeAutour;
    private boolean presenceDrapeau = false; //au depart on n'a ni bombe ni drapeau
    private boolean cache = true;

    public boolean isCache() {
        return cache;
    }

    public boolean placerBombe() {
        alea = (int) (Math.random() * 8); //on genere un double aleatoire entre 0 et 8
        if (alea == 1) {
            presenceBombe = true;
            return true;
        }
        return false;
    }

    public void enleverBombe() {
        presenceBombe = false;
    }

    public void enleverDrapeau() {
        presenceDrapeau = false;
    }

    public void placerDrapeau() {
        presenceDrapeau = true;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public boolean PresenceBombe() {
        return presenceBombe;
    }

    public int getBombeAutour() {
        return bombeAutour;
    }

    public boolean PresenceDrapeau() {
        return presenceDrapeau;
    }

    public void setBombeAutour(int bombeAutour) {
        this.bombeAutour = bombeAutour;
    }

}
