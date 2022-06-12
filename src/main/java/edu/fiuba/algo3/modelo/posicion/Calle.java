package edu.fiuba.algo3.modelo.posicion;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

abstract public class Calle {
    protected Posicion posicionDeUnLado;
    protected Posicion posicionDelotroLado;

    abstract public Posicion obtenerEsquinaOpuesta (Posicion posicionOrigen);
    abstract public Posicion serTransitada (Vehiculo unVehiculo);
}