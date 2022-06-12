package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class MovimientoComun implements Movimiento {

    private Direccion unaDireccion;

    public MovimientoComun(Direccion unaDireccion){
        this.unaDireccion = unaDireccion;
    }

    public Posicion moverseDesde(Posicion unaPosicion, Vehiculo unVehiculo ) {
        return unaPosicion.obtenerSumaDeCoordenadas( unaDireccion.posicionRelativa());
    }
}
