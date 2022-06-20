package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class CambioDeVehiculo implements Sorpresa, Ubicable {
    private Posicion unaPosicion;
    public CambioDeVehiculo(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
    }
    public CambioDeVehiculo () {
    }

    public void serEncontradoPor (Vehiculo unVehiculo) {
        unVehiculo.proximoVehiculo();
    }

    public boolean estaEnPosicion(Posicion unaPosicion){
       return this.unaPosicion.igualA(unaPosicion);
    }
}