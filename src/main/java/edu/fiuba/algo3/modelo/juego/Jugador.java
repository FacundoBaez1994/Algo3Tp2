package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador implements Comparable<Jugador> {
    private String nickname;
    private int puntaje;
    Vehiculo unVehiculo;

    public Jugador (String unNickname) {
        this.nickname = unNickname;
        this.puntaje = 0;
    }
    public Jugador () {
        this.puntaje = 0;
    }
    public Jugador (String unNickname, int unPuntaje) {
        this.nickname = unNickname;
        this.puntaje = unPuntaje;
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
    public String getNickName () {
        return this.nickname;
    }

    public Vehiculo getVehiculo() {
        return this.unVehiculo;
    }

    @Override
    public int compareTo(Jugador otroJugador) {
        if(otroJugador.puntaje > this.puntaje){
            return -1;
        }else if(otroJugador.puntaje == this.puntaje){
            return 0;
        }else{
            return 1;
        }
    }
}
