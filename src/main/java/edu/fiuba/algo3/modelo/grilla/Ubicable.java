package edu.fiuba.algo3.modelo.grilla;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Ubicable {
    public abstract boolean estaEnPosicion(Posicion unaPosicion);
    public abstract void serEncontradoPor(Vehiculo unVehiculo);
}
