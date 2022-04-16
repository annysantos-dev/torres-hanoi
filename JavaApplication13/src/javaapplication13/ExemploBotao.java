/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication13;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ferdinand
 */
public class ExemploBotao extends JFrame{
    JButton iniciar;
    int discos=1;
    public ExemploBotao(){
        super("Torres de Hanoi");
        Container tela = getContentPane();
        setLayout(null);
        iniciar = new JButton("Iniciar");
        
        iniciar.setBounds(30,20,130,30);
        
        
        
        iniciar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        ArrayList disco = new ArrayList(10);
                        ArrayList pino = new ArrayList(3);
                        Jogo novo = new Jogo();
     
                        disco=novo.GerarDiscos(140,120,100,60,discos);
                        pino=novo.GerarPinos(140, 120, 60, discos);      
      
                        if(discos>0) { novo.transfere(disco, pino, discos, discos-1, 0, 2, 1); }
                    }
        });
        tela.add(iniciar);
        
        //setLocationRelativeTo(null);
        setSize(470,100);
        setVisible(true);
        
    }
    public static void main(String args[]){
        
        int num,x,y,x_pos=100,y_pos=0;
        
        int dx = 950;
        int dy = 500;
        ArrayList disco = new ArrayList(10);
        ArrayList pino = new ArrayList(3);
        Jogo novo = new Jogo();
        JFrame frame = new JFrame( "Torres" );
        disco=novo.GerarDiscos(140,120,100,60,1);
        pino=novo.GerarPinos(140, 120, 60, 1);
        
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( dx, dy ); 
	ShapesJPanel2 shapesJPanel = new ShapesJPanel2(disco,pino,1);
        frame.add( shapesJPanel);
        frame.setVisible( true ); 
        
        ExemploBotao app = new ExemploBotao();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
