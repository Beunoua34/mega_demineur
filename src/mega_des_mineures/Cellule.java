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
    private boolean presenceBombe=false;
    private int bombeAutour;
    private boolean presenceDrapeau=false; //au depart on n'a ni bombe ni drapeau
    public void placerBombe(){
        presenceBombe=true;
    } 
    public void placerDrapeau(){
        presenceDrapeau=true;
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
