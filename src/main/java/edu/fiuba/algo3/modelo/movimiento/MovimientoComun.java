package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.Grilla;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class MovimientoComun implements Movimiento {

    private Direccion unaDireccion;

    public MovimientoComun(Direccion unaDireccion){
        this.unaDireccion = unaDireccion;
    }

    public Posicion moverse (Posicion unaPosicion, Vehiculo unVehiculo ) {
        Posicion otraPosicion = unaPosicion.obtenerSumaDeCoordenadas( unaDireccion.posicionRelativa());
        Grilla grilla = Grilla.getInstance();
        grilla.aplicarElementosAVehiculo (otraPosicion, unVehiculo);
        return otraPosicion;
    }
}
