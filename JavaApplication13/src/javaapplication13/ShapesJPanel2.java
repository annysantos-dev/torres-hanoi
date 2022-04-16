package javaapplication13;

import java.lang.Thread.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ShapesJPanel2 extends JPanel 
{
    int num=0;
    private Image dbImage;
    private Graphics dbg;
    ArrayList disco = new ArrayList(10);
    ArrayList pino = new ArrayList(3);
    
    public ShapesJPanel2( ArrayList a, ArrayList b,int n){
        disco=a;
        pino=b;
        num=n;
    }
    
    @Override
   
    public void paintComponent( Graphics g )
   {
      //método padrão que desenha tudo
      super.paintComponent( g ); 
      System.setProperty( "swing.aatext", "true" ); 
      Graphics2D g2d = ( Graphics2D ) g; 
      
      //Pinos
      
      //pino 1
      //.setPaint define a cor em gradiente a metade braca e a outra metade cinza
      g2d.setPaint( new GradientPaint(((Pino)pino.get(0)).x, ((Pino)pino.get(0)).y, 
         Color.WHITE, ((Pino)pino.get(0)).z, ((Pino)pino.get(0)).y, Color.GRAY) );  
      //.fill desenha uma figura preenchida - Rectangle2D.Double desenha um retangulo 
      g2d.fill( new Rectangle2D.Double(((Pino)pino.get(0)).x, ((Pino)pino.get(0)).y, 15, ((Pino)pino.get(0)).comp) );

      //pino 2
      g2d.setPaint( new GradientPaint(((Pino)pino.get(1)).x, ((Pino)pino.get(1)).y, 
         Color.WHITE, ((Pino)pino.get(1)).z, ((Pino)pino.get(1)).y, Color.GRAY) );  
      g2d.fill( new Rectangle2D.Double(((Pino)pino.get(1)).x, ((Pino)pino.get(1)).y, 15, ((Pino)pino.get(1)).comp) );
      
      //pino 3
      g2d.setPaint( new GradientPaint(((Pino)pino.get(2)).x, ((Pino)pino.get(2)).y, 
         Color.WHITE, ((Pino)pino.get(2)).z, ((Pino)pino.get(2)).y, Color.GRAY) );  
      g2d.fill( new Rectangle2D.Double(((Pino)pino.get(2)).x, ((Pino)pino.get(2)).y, 15, ((Pino)pino.get(2)).comp) );

       //pino 4
       g2d.setPaint( new GradientPaint(((Pino)pino.get(3)).x, ((Pino)pino.get(3)).y,
               Color.WHITE, ((Pino)pino.get(3)).z, ((Pino)pino.get(3)).y, Color.GRAY) );
       g2d.fill( new Rectangle2D.Double(((Pino)pino.get(3)).x, ((Pino)pino.get(3)).y, 15, ((Pino)pino.get(2)).comp) );

       //os discos
      for(int i=0;i<num;i++){
            //.setPaint define as cores do disco em gradiente metade azul metade preta
            g2d.setPaint( new GradientPaint(((Disco)disco.get(i)).x,((Disco)disco.get(i)).y, Color.BLUE, ((Disco)disco.get(i)).x, ((Disco)disco.get(i)).z, 
            Color.BLACK) );  
            //.fill desenha uma figura preenchida - RoundRectangle2D.Dlouble desenha um retângulo com as pontas arredondadas
            g2d.fill( new RoundRectangle2D.Double(((Disco)disco.get(i)).x, ((Disco)disco.get(i)).y, ((Disco)disco.get(i)).comp, 20, 30, 30 ) );
      }
   } 
    
    //método padrão que agiliza o processamento criando uma imagem do quadro seguinte antes de ser mostrado
    public void update (Graphics g)
    {

      
      if (dbImage == null)
      {
            dbImage = createImage (this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics ();
      }

      
      dbg.setColor (getBackground ());
      dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);

      
      dbg.setColor (getForeground());
      paint (dbg);

      
      g.drawImage (dbImage, 0, 0, this);

   }

    
}