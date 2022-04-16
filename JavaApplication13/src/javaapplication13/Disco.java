package javaapplication13;

public class Disco{
    //coordenadas do disco
    int x=0;
    int y=0;
    int z; //usada na cor gradiente
    int comp=0;
    int pino=0;
    //construtor do disco
    public Disco(int x,int y,int comp,int pino){
        this.x=x;
        this.y=y;
        z=y+20;
        this.comp=comp;
        this.pino=pino;
    }
}