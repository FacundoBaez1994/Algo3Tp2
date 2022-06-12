package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.esquina.Calle;
import edu.fiuba.algo3.modelo.esquina.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Movimiento {
    public abstract Posicion moverseDesde(Posicion unaPosicion, Vehiculo unVehiculo );
}
