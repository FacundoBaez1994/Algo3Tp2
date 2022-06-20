package edu.fiuba.algo3.modelo.grilla;

import edu.fiuba.algo3.modelo.excepciones.LlegadaALaMeta;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Meta implements Ubicable {
    private Posicion unaPosicion;

    public Meta () {};

    public Meta (Posicion posicion) {
        this.unaPosicion = posicion;
    };

    @Override
    public boolean estaEnPosicion(Posicion unaPosicion) {
        return this.unaPosicion.igualA(unaPosicion);
    }

    @Override
    public void serEncontradoPor(Vehiculo unVehiculo) {
        throw new LlegadaALaMeta();
    }
}
