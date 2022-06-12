package edu.fiuba.algo3.modelo.direcciones;

import edu.fiuba.algo3.modelo.esquina.Posicion;

public class Izquierda implements Direccion {

        public Posicion posicionRelativa(){
            return new Posicion(-1,0);
        }

}
