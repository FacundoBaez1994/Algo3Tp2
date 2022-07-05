package edu.fiuba.algo3.modelo.sorpresa;

import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Sorpresa;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Sorpressata implements Sorpresa, Ubicable{

    private Posicion unaPosicion;
    private CambioDeVehiculo cambioDeVehiculo;
    private Piquete piquete;

    public Sorpressata(Posicion unaPosicion){
        this.unaPosicion = unaPosicion;
        this.cambioDeVehiculo = new CambioDeVehiculo(unaPosicion);
        this.piquete = new Piquete(unaPosicion);
    }
    public Sorpressata () {
    }

    public void serEncontradoPor (Vehiculo unVehiculo) {
        if(unVehiculo.verificarParidadDeMovimientos()){
            this.cambioDeVehiculo.serEncontradoPor(unVehiculo);
        } else {
            this.piquete.serEncontradoPor((unVehiculo));
        }
    }

    public boolean estaEnPosicion(Posicion unaPosicion){
        return this.unaPosicion.igualA(unaPosicion);
    }
}

