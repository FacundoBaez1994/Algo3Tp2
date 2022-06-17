package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Ubicables {
    public abstract boolean estaEnPosicion(Posicion unaPosicion);
    public abstract void serEncontradoPor(Vehiculo unVehiculo);
}
