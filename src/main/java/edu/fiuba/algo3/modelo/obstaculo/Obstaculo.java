package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Obstaculo {
    //public abstract int calcularPenalizacion (TipoDeVehiculo unTipo);
    public abstract void serEncontradoPor (Vehiculo unVehiculo);
}
