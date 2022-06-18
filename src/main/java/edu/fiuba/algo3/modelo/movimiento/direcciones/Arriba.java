package edu.fiuba.algo3.modelo.movimiento.direcciones;

import edu.fiuba.algo3.modelo.posicion.Posicion;


public class Arriba implements Direccion {

    public Posicion posicionRelativa(){
        return new Posicion(0,1);
    }

}