package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.Ubicables;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Obstaculo, Ubicables {
    private Posicion unaPosicion;
    public Piquete(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
    }
    public int calcularPenalizacion (TipoDeVehiculo unTipo) {
        return unTipo.calcularPenalizacion(this);
    }
    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.unaPosicion.equals(unaPosicion);
    }
    public void serEncontradoPor (Vehiculo unVehiculo){
        unVehiculo.calcularPenalizacion(this);
    };
}
