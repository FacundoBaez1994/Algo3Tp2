package edu.fiuba.algo3.modelo.direcciones;

import edu.fiuba.algo3.modelo.esquina.Posicion;


public class Abajo implements Direccion {

    public Posicion posicionRelativa(){
        return new Posicion(0,-1);
    }

}