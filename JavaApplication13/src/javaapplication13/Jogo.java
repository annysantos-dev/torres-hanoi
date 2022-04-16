package javaapplication13;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Jogo{
    JFrame frame = new JFrame("Torres de Hanoi"); //frame principal

    int velox = 20; //tempo de "sleep" da thread
    int e=20;       //unidade de movimentação dos discos
    int dx = 950;   //dimesão x da janela
    int dy = 500;   //dimesão y da janela
    
    //método que gera as os discos (as coordenadas)
    public ArrayList GerarDiscos(int x,int y,int z,int comp,int num){
       ArrayList disco = new ArrayList(10);
       disco.add(new Disco(x,y,comp,0));
       for(int i=0;i<num;i++){
            x=x-10;
            y=y+20;
            z=z+20;
            comp=comp+20;
            disco.add(new Disco(x,y,comp,0));
            ((Disco)disco.get(i)).pino=0;
       }
       return disco;
   }
   
    //método que gera os pinos (as coordenadas
   public ArrayList GerarPinos(int x,int y,int comp,int num){
      ArrayList pino = new ArrayList(3);
      int dist=(x+22)+(((num-1)*20)/2)+comp;
      pino.add(new Pino(x+22,y-20,x+39,(num*20)+20,num));
      pino.add(new Pino(x+22+dist,y-20,x+39+dist,(num*20)+20,0));
      pino.add(new Pino(x+22+(2*dist),y-20,x+39+(2*dist),(num*20)+20,0));         
      return pino;
   }
   //método que move o disco para direita
   
   public void MoverXd(ArrayList a, ArrayList b,int num, int d, int x){
       int x_pos=0;
       int y_pos=0;
       int comp=0;
       
       ArrayList disco=a;
       ArrayList pino=b;
       x_pos=((Disco)disco.get(d)).x;
       y_pos=((Disco)disco.get(d)).y;
       comp=((Disco)disco.get(d)).comp;
       
            
       Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
      
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setSize( dx, dy ); 
	
            while(x_pos<x){
            
            ShapesJPanel2 shapesJPanel = new ShapesJPanel2(disco,pino,num);
            frame.add( shapesJPanel);
            frame.setVisible( true ); 
            disco.remove(d);
            disco.add(d,new Disco(x_pos,y_pos,comp,num));
            if((x-x_pos)<20) { x_pos++; }
            else { x_pos+=e; }
            
            try
            {
                  Thread.sleep (velox);
            }
            catch (InterruptedException ex)
            {
            // faz nada
            }

            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
        
   }
   
   //método que move o disco para esquerda
   
   public void MoverXe(ArrayList a, ArrayList b,int num, int d, int x){
       int x_pos=0;
       int y_pos=0;
       int comp=0;
       
       ArrayList disco=a;
       ArrayList pino=b;
       x_pos=((Disco)disco.get(d)).x;
       y_pos=((Disco)disco.get(d)).y;
       comp=((Disco)disco.get(d)).comp;
       
            
       Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
      
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setSize( dx, dy ); 
	
            while(x_pos>x){
            
            ShapesJPanel2 shapesJPanel = new ShapesJPanel2(disco,pino,num);
            frame.add( shapesJPanel);
            frame.setVisible( true );
            disco.remove(d);
            disco.add(d,new Disco(x_pos,y_pos,comp,num));
            if((x_pos-x)<20) { x_pos--; }
            else { x_pos-=e; }
            
            try
            {
                Thread.sleep (velox);
            }
            catch (InterruptedException ex)
            {
            // faz nada
            }

            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
   }
   //método que move o disco para baixo
        public void MoverYab(ArrayList a, ArrayList b,int num, int d, int y){
            int x_pos=0;
            int y_pos=0;
            int comp=0;
            ArrayList disco=a;
            ArrayList pino=b;
            x_pos=((Disco)disco.get(d)).x;
            y_pos=((Disco)disco.get(d)).y;
            comp=((Disco)disco.get(d)).comp;
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            
            
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setSize( dx, dy );
            
            while(y_pos<y){
            
            ShapesJPanel2 shapesJPanel = new ShapesJPanel2(disco,pino,num);
            frame.add( shapesJPanel);
            frame.setVisible( true ); 
            disco.remove(d);
            disco.add(d,new Disco(x_pos,y_pos,comp,num));
            y_pos+=e;
            try
            {
               Thread.sleep (velox);
            }
            catch (InterruptedException ex)
            {
            // faz nada
            }

            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
   }
        //método que move o disco para cima
        public void MoverYac(ArrayList a, ArrayList b,int num, int d, int y){
            int x_pos=0;
            int y_pos=0;
            int comp=0;
            ArrayList disco=a;
            ArrayList pino=b;
            x_pos=((Disco)disco.get(d)).x;
            y_pos=((Disco)disco.get(d)).y;
            comp=((Disco)disco.get(d)).comp;
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            
            
            //frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setSize( dx, dy ); 
            
            while(y_pos>y){
            
            ShapesJPanel2 shapesJPanel = new ShapesJPanel2(disco,pino,num);
            frame.setLocationRelativeTo(null);
            frame.add( shapesJPanel);
            frame.setVisible( true ); 
            disco.remove(d);
            disco.add(d,new Disco(x_pos,y_pos,comp,num));
            y_pos-=e;
            try
            {
               Thread.sleep (velox);
            }
            catch (InterruptedException ex)
            {
            // faz nada
            }

            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
   }
        //método que move o disco de um pino para o outro
        public void MoverDisco(ArrayList a, ArrayList b, int num, int d, int po, int pd){
            int dx_pos=0;
            int px_pos=0;
            int py_pos=0;
            dx_pos=((Disco)a.get(d)).x;
            px_pos=((Pino)b.get(pd)).x;
            py_pos=((Pino)b.get(pd)).y;
            Pino aux1 = ((Pino)b.get(pd));
            Pino aux2 = ((Pino)b.get(po));
            this.MoverYac(a, b, num, d, 30);
            if(dx_pos<px_pos){ this.MoverXd(a, b, num, d, px_pos-(22+10*d)); }
            else { this.MoverXe(a, b, num, d, px_pos-(22+10*d)); }
            this.MoverYab(a, b, num, d, py_pos+((Pino)b.get(pd)).comp-(((Pino)b.get(pd)).qntdiscos*20)-18);
            b.remove(pd);
            b.add(pd,new Pino(aux1.x,aux1.y,aux1.z,aux1.comp,aux1.qntdiscos+1));
            b.remove(po);
            b.add(po,new Pino(aux2.x,aux2.y,aux2.z,aux2.comp,aux2.qntdiscos-1));
        }
        
        //solução das torres de hanoi
        public void transfere(ArrayList disco, ArrayList pino,int num,int disc, int o, int d, int a){
            if(disc==0){
                this.MoverDisco(disco, pino, num, disc, o, d);
            }
            else{
                this.transfere(disco, pino, num,disc-1, o, a, d);
                this.MoverDisco(disco, pino, num, disc, o, d);
                this.transfere(disco, pino, num,disc-1, a, d, o);
            }
        }
}