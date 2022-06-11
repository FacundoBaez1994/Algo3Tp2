package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo implements Obstaculo {
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals( obj.getClass() );
    }

    public void afectarMovimientos (Vehiculo unVehiculo) {
        unVehiculo.afectarMovimientos(this);
    }

}
