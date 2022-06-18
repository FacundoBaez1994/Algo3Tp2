package edu.fiuba.algo3.modelo.posicion;

public class Posicion {
    protected int coordenadaX;
    protected int coordenadaY;

     public Posicion(int x, int y){
         this.coordenadaX = x;
         this.coordenadaY = y;
     }

     public void sumarCoordenadas(Posicion otraPosicion) {
         this.coordenadaX = this.coordenadaX + otraPosicion.coordenadaX;
         this.coordenadaY = this.coordenadaY + otraPosicion.coordenadaY;
     }

     public Posicion obtenerSumaDeCoordenadas(Posicion otraPosicion) {
         return new Posicion(this.coordenadaX + otraPosicion.coordenadaX,
                 this.coordenadaY + otraPosicion.coordenadaY );
     }

     public boolean igualA (Posicion otraPosicion) {
         if (this.coordenadaX == otraPosicion.coordenadaX &&
                 this.coordenadaY == otraPosicion.coordenadaY)
             return true;
         else
             return false;
     }

}
