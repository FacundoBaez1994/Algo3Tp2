package edu.fiuba.algo3.modelo;

public class MovimientoComun implements Movimiento {

    private Direccion unaDireccion;

    public MovimientoComun(Direccion unaDireccion){
        this.unaDireccion = unaDireccion;
    }

    public void mover(Calle unaCalle, Vehiculo unVehiculo ){
        unaCalle.serTransitada(unVehiculo);
    }
}
