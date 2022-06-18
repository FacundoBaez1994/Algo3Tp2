package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Movimiento {
    public abstract void moverse (Vehiculo unVehiculo);
}
