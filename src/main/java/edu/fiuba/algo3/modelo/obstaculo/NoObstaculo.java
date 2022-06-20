package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.*;

public class NoObstaculo implements Obstaculo, Ubicable {

    private Posicion unaPosicion;
    public NoObstaculo(){}
    public NoObstaculo(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
    }
    public int calcularPenalizacion (TipoDeVehiculo unTipo) {
        return 0;
    }
    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.unaPosicion.igualA(unaPosicion);
    }
    public void serEncontradoPor (Vehiculo unVehiculo){
        unVehiculo.calcularPenalizacion(this);
    };

}