package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.esquina.Calle;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class MovimientoComun implements Movimiento {

    private Direccion unaDireccion;

    public MovimientoComun(Direccion unaDireccion){
        this.unaDireccion = unaDireccion;
    }

    public void mover(Calle unaCalle, Vehiculo unVehiculo ){
        unaCalle.serTransitada(unVehiculo);
    }
}
