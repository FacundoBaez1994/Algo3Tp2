package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.posicion.Posicion;

public class Grilla {
    // Singleton pattern
    private static Grilla INSTANCE = null;

    private final int maximaCantidadDePosicionesEnX = 20;
    private final int maximaCantidadDePosicionesEnY = 20;

    private Posicion[][] posiciones = new Posicion[this.maximaCantidadDePosicionesEnX][this.maximaCantidadDePosicionesEnY];

    private Grilla(){
        //this.crearPosiciones();
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




}
