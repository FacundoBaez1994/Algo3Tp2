package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public interface Obstaculo {
    public abstract boolean equals(Object obj);
     public abstract void afectarMovimientos (Vehiculo unVehiculo);
}
