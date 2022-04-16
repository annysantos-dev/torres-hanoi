/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication13;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ferdinand
 */
public class Main extends JFrame{
    JButton iniciar;
    JLabel discos;
    public Main(){
        super("Torres de Hanoi");
        Container tela = getContentPane();
        iniciar = new JButton("Iniciar");
        
        iniciar.setBounds(50,20,100,20);
        tela.add(iniciar);
        
        //setLocationRelativeTo(null);
        setSize(400,150);
        setVisible(true);
        
    }
    public static void main(String args[]){
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
