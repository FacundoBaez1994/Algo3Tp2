package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class CambioDeVehiculo implements Sorpresa {

    public CambioDeVehiculo () {
    }

    public void serEncontradaPor (Vehiculo unVehiculo) {
        unVehiculo.proximoVehiculo();
    }
}