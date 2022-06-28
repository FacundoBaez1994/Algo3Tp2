package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.TipoDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Juego {
    // Singleton pattern

    private Queue<Jugador> jugadores = null;
    private PuntajesAltos unosPuntajes;
    private String datosDelJugadorActual = null;

    private static Juego INSTANCE = null;

    public static Juego getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Juego ();
        }
        return INSTANCE;
    }
    private Juego (){
        this.jugadores = new LinkedList<>();
    }

    public void agregarJugador (Jugador unJugador){
        this.jugadores.add (unJugador);
    }

    public void jugadorConTurnoActualMueveVehiculo (Direccion unaDireccion) {
        Jugador unJugador = this.jugadores.peek();
        try {
            unJugador.moverVehiculoHacia(unaDireccion);
        } catch (Exception e) {
            throw e;
        }
        this.jugadores.poll();
        this.jugadores.add(unJugador);
    }
    public void reiniciar() {
        this.jugadores =  new LinkedList<>();
    }

    public TipoDeVehiculo obtenerVehiculoEnPosicion (Posicion unaPosicion){
        TipoDeVehiculo unVehiculoEnPosicion = null;
        for (int i = 0; i < this.jugadores.size(); i++) {
            Jugador unJugador = this.jugadores.poll();
            TipoDeVehiculo unVehiculo = unJugador.obtenerVehiculoEnPosicion(unaPosicion);
            if (unVehiculo  != null) {
                unVehiculoEnPosicion = unVehiculo;
            }
            this.jugadores.add(unJugador);
         }
        return unVehiculoEnPosicion;
    }
    public String obtenerNicknameJugadorActual (){
        Jugador unJugador =  this.jugadores.peek();
        return unJugador.getNickName();
    }
    public int obtenerPuntajeJugadorActual (){
        Jugador unJugador =  this.jugadores.peek();
        return unJugador.getPuntaje();
    }
    public Posicion obtenerPosicionDeJugadorActual (){
        Jugador unJugador = this.jugadores.peek();
        return unJugador.getVehiculo().getPosicion();
    }

    public void huboGanador (){
        Jugador unJugador = this.jugadores.peek();
        this.datosDelJugadorActual = unJugador.getNickName() + "Con puntaje: " + unJugador.getPuntaje();
    }
    public String obtenerGanador (){
        return this.datosDelJugadorActual;
    }

}
