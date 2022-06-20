package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Obstaculo, Ubicable {
    private Posicion unaPosicion;
    public Piquete(){}
    public Piquete(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
    }
    public int calcularPenalizacion (TipoDeVehiculo unTipo) {
        return unTipo.calcularPenalizacion(this);
    }
    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.unaPosicion.igualA(unaPosicion);
    }
    public void serEncontradoPor (Vehiculo unVehiculo){
        unVehiculo.calcularPenalizacion(this);
    };
}
