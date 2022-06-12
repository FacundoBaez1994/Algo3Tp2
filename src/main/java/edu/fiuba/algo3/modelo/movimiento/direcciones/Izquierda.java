package edu.fiuba.algo3.modelo.movimiento.direcciones;

import edu.fiuba.algo3.modelo.posicion.Posicion;

public class Izquierda implements Direccion {

        public Posicion posicionRelativa(){
            return new Posicion(-1,0);
        }

}
