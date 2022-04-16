package javaapplication13;


import java.lang.Thread.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Shapes extends Thread{
   public Shapes(){
        // criação da thread
        Thread th = new Thread (this);
	
        th.start (); //inicialização da thread
        
   }
   
   public static void main( String args[] )
   
   {  
      int num;
      ArrayList disco = new ArrayList(10); //lista de discos
      ArrayList pino = new ArrayList(3); //lista de discos
      Jogo novo = new Jogo();            // criação do objeto da classe que gera os discos e pinos e movimenta os discos
      
      num=Integer.parseInt(JOptionPane.showInputDialog(null,"Qual a quantidade de discos?")); 
      disco=novo.GerarDiscos(140,120,100,60,num);  // gerando discos a partir das coordenadas do primeiro disco (x,y,z,comprimento) 
      pino=novo.GerarPinos(140, 120, 60, num);     // gerando pinos a partir das coordenadas do primeiro disco (x,y,comprimento,num)
      
      if(num>0) { novo.transfere(disco, pino, num, num-1, 0, 3, 2, 1); } //solução das torres de hanoi
          
   } 
} 












