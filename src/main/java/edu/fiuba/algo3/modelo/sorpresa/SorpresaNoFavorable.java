package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.Ubicables;
import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class SorpresaNoFavorable implements Sorpresa, Ubicables {

    private double porcentaje;
    private Posicion unaPosicion;
    public SorpresaNoFavorable(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
    }
    public SorpresaNoFavorable () {
        this.porcentaje = 25;
    }

    public void serEncontradoPor (Vehiculo unVehiculo) {
        unVehiculo.aumentarCantidadMovimientosEnPorcentaje(this.porcentaje);
    }
    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.unaPosicion.equals(unaPosicion);
    }
}