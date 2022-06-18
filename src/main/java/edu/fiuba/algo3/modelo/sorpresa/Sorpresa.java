package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Sorpresa {
    public abstract void serEncontradoPor (Vehiculo unVehiculo);
}