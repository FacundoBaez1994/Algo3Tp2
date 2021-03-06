package edu.fiuba.algo3.modelo.posicion;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.grilla.Grilla;

public class Posicion {
    protected int coordenadaX;
    protected int coordenadaY;

     public Posicion(int x, int y){
         this.coordenadaX = x;
         this.coordenadaY = y;
     }

    public Posicion(Posicion unaPosicion){
        this.coordenadaX = unaPosicion.obtenerCoordenadaX();
        this.coordenadaY = unaPosicion.obtenerCoordenadaY();
    }

     public void sumarCoordenadas(Posicion otraPosicion) {

         int resultadoEnX = this.coordenadaX + otraPosicion.coordenadaX;
         int resultadoEnY = this.coordenadaY + otraPosicion.coordenadaY;
         Grilla grilla = Grilla.getInstance();
         grilla.comprobarCoordenadasDentroDeLosLimites(resultadoEnX, resultadoEnY);
         this.coordenadaX = resultadoEnX;
         this.coordenadaY = resultadoEnY;

     }

     public Posicion obtenerSumaDeCoordenadas(Posicion otraPosicion) {
         return new Posicion(this.coordenadaX + otraPosicion.coordenadaX,
                 this.coordenadaY + otraPosicion.coordenadaY );
     }

    public int obtenerCoordenadaX() {
        return this.coordenadaX;
    }

    public int obtenerCoordenadaY() {
        return this.coordenadaY;
    }

     public boolean igualA (Posicion otraPosicion) {
         if (this.coordenadaX == otraPosicion.coordenadaX &&
                 this.coordenadaY == otraPosicion.coordenadaY)
             return true;
         else
             return false;
     }
    public int obtenerDistanciaMayor(Posicion otraPosicion) {
        int compMasGrande = 0;
        int componenteX = Math.abs(this.coordenadaX - otraPosicion.coordenadaX);
        int componenteY = Math.abs(this.coordenadaY - otraPosicion.coordenadaY);
        if ( componenteX < componenteY) { compMasGrande = componenteY; }
        else { compMasGrande = componenteX; };
        return compMasGrande;
    }
}
