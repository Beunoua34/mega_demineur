/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mega_des_mineures;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * * @author guilh
 */
public class CelluleGraphique extends JButton {

    Cellule celluleAssociee;

    public CelluleGraphique(Cellule uneCellule) {
        celluleAssociee = uneCellule;
    }
    ImageIcon un = new javax.swing.ImageIcon(getClass().getResource("/Images/1.png"));
    ImageIcon bombe = new javax.swing.ImageIcon(getClass().getResource("/Images/bombe.png"));
    ImageIcon quatre = new javax.swing.ImageIcon(getClass().getResource("/Images/4.png"));
    ImageIcon trois = new javax.swing.ImageIcon(getClass().getResource("/Images/3.png"));
    ImageIcon deux = new javax.swing.ImageIcon(getClass().getResource("/Images/2.png"));
    ImageIcon cinq = new javax.swing.ImageIcon(getClass().getResource("/Images/5.png"));
    ImageIcon six = new javax.swing.ImageIcon(getClass().getResource("/Images/6.png"));
    ImageIcon cache = new javax.swing.ImageIcon(getClass().getResource("/Images/cache.png"));
    ImageIcon drapeau = new javax.swing.ImageIcon(getClass().getResource("/Images/drapeau.png"));
    ImageIcon vide = new javax.swing.ImageIcon(getClass().getResource("/Images/vide.png"));
    
    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssociee.isCache()) {
            if (celluleAssociee.PresenceDrapeau()) {
               setIcon(drapeau);
            } else {
                setIcon(cache);
            }
        } else if (celluleAssociee.PresenceBombe()) {
            setIcon(bombe);
        } else {
            if (celluleAssociee.getBombeAutour() == 1) {
                setIcon(un);
            }
            if (celluleAssociee.getBombeAutour() == 2) {
                setIcon(deux);
            }
            if (celluleAssociee.getBombeAutour() == 3) {
                setIcon(trois);
            }
            if (celluleAssociee.getBombeAutour() == 4) {
                setIcon(quatre);
            }
            if (celluleAssociee.getBombeAutour() == 5) {
                setIcon(cinq);
            }
            if (celluleAssociee.getBombeAutour() == 6) {
                setIcon(six);
            }
            if (celluleAssociee.getBombeAutour()==0){
                setIcon(vide);
            }
        }
        
    }
}
