package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador implements Comparable<Jugador> {
    private String nickname;
    private int puntaje;
    public static int cantidadDeJugadores = 1;
    private int numeroDeJugador = 0;
    Vehiculo unVehiculo;

    public Jugador (String unNickname) {
        this.numeroDeJugador = cantidadDeJugadores;
        this.nickname = unNickname;
        this.puntaje = 0;
    }
    public Jugador () {
        this.numeroDeJugador = cantidadDeJugadores;
        this.puntaje = 0;
    }
    public Jugador (String unNickname, int unPuntaje) {
        this.numeroDeJugador = cantidadDeJugadores;
        this.nickname = unNickname;
        this.puntaje = unPuntaje;
    }

    public Jugador (String unNickname, Posicion unaPosicion) {
        this.numeroDeJugador = cantidadDeJugadores++;
        this.nickname = unNickname;
        this.puntaje = 0;
        this.unVehiculo = new Vehiculo(new Moto(), unaPosicion);
    }

    public Jugador (String unNickname, TipoDeVehiculo unTipoDeVehiculo, Posicion unaPosicion) {
        this.numeroDeJugador = cantidadDeJugadores;
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

    public String getNickname () {
        return this.nickname;
    }

    public Vehiculo getVehiculo() {
        return this.unVehiculo;
    }

    public int getNumeroDeJugador() {
        return this.numeroDeJugador;
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

    public TipoDeVehiculo obtenerVehiculoEnPosicion(Posicion unaPosicion) {
        TipoDeVehiculo vehiculoEnPosicion = null;
        if (this.unVehiculo.estaEnPosicion (unaPosicion)) {
            vehiculoEnPosicion = unVehiculo.getTipoDeVehiculo();
        }
        return vehiculoEnPosicion;
    }
}
