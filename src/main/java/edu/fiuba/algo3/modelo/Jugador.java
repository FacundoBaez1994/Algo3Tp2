package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
    private String nickname;
    private int puntaje;
    Vehiculo unVehiculo;

    public Jugador (String unNickname) {
        this.nickname = unNickname;
        this.puntaje = 0;
    }

    public Jugador (String unNickname, Posicion unaPosicion) {
        this.nickname = unNickname;
        this.puntaje = 0;
        this.unVehiculo = new Vehiculo(new Moto(), unaPosicion);
    }

    public Jugador (String unNickname, TipoDeVehiculo unTipoDeVehiculo, Posicion unaPosicion) {
        this.nickname = unNickname;
        this.puntaje = 0;
        this.unVehiculo = new Vehiculo(unTipoDeVehiculo, unaPosicion);
    }

    public void moverVehiculoHacia (Direccion unaDireccion) {
        this.unVehiculo.moverseHacia (unaDireccion);
        this.puntaje = this.unVehiculo.getCantidadDeMovimientos();
    }

    public int getPuntaje () {
        return this.puntaje;
    }
}
