package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class SorpresaNoFavorable implements Sorpresa {

    private double porcentaje;
    public SorpresaNoFavorable () {
        this.porcentaje = 25;
    }

    public void serEncontradaPor (Vehiculo unVehiculo) {
        unVehiculo.aumentarCantidadMovimientosEnPorcentaje(this.porcentaje);
    }
}