package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.Ubicables;
import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;


public class NoSorpresa implements Sorpresa, Ubicables {

    private Posicion unaPosicion;
    public NoSorpresa(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
    }
    public NoSorpresa() {
    }

    public void serEncontradoPor(Vehiculo unVehiculo) {
    }

    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.unaPosicion.igualA(unaPosicion);
    }
}