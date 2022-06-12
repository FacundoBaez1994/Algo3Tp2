package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Grilla {
    // Singleton pattern
    private static Grilla INSTANCE = null;

    private final int maximaCantidadDePosicionesEnX = 20;
    private final int maximaCantidadDePosicionesEnY = 20;

   // private final int maximaCantidadDePosicionesEnY = 20;

    private Posicion[][] posiciones = new Posicion[this.maximaCantidadDePosicionesEnX][this.maximaCantidadDePosicionesEnY];

    private Grilla(){
        this.crearPosiciones();
    }
    public static Grilla getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Grilla();
        }
        return INSTANCE;
    }

    public Posicion[][] getPosiciones(){
        return this.posiciones;
    }

    private void crearPosiciones() {
        for(int i = 0; i < this.maximaCantidadDePosicionesEnX; i++ ){
            for(int j = 0; j < this.maximaCantidadDePosicionesEnY ; j++ ) {
                this.posiciones [i][j] = new Posicion (i,j);
            }
        }
    }
    public void aplicarElementosAVehiculo (Posicion posicion, Vehiculo unVehiculo) {
        ArrayList <Elementos> elementos =  this.buscarElementosEn (posicion);
    }

    private void buscarElementosEn(Posicion posicion) {
        for(int i = 0; i < this.maximaCantidadDePosicionesEnX; i++ ){
            for(int j = 0; j < this.maximaCantidadDePosicionesEnY ; j++ ) {
                // que elemento tienen la posicion
            }
        }
    }
}




