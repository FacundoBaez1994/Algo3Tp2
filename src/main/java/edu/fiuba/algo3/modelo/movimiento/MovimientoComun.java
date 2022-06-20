package edu.fiuba.algo3.modelo.movimiento;

import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class MovimientoComun implements Movimiento {

    private Direccion unaDireccion;

    public MovimientoComun(Direccion unaDireccion){
        this.unaDireccion = unaDireccion;
    }

    public void moverse (Vehiculo unVehiculo ) {
        unVehiculo.cambiarPosicionHacia(unaDireccion.posicionRelativa());
        Grilla grilla = Grilla.getInstance();
        grilla.aplicarElementoUbicableAVehiculo (unVehiculo);
    }
}
