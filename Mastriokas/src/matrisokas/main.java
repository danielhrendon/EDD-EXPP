/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrisokas;

import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Muñeca GUI = new Muñeca();
       GUI.setVisible(true);
       GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       GUI.setLocationRelativeTo(null);
    }
    
}
