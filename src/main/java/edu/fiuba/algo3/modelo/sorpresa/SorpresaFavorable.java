package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class SorpresaFavorable implements Sorpresa {

    private int porcentaje;
    public SorpresaFavorable () {
        this.porcentaje = 20;
    }

    public void serEncontradaPor (Vehiculo unVehiculo) {
        unVehiculo.disminuirCantidadMovimientosEnPorcentaje(this.porcentaje);
    }
}
