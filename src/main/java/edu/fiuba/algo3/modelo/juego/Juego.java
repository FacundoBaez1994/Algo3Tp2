package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.excepciones.PosicionFueraDeLimite;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Juego {
    // Singleton pattern

  //  private ArrayList <Jugador> jugadores = null;
    private Queue<Jugador> jugadores = null;
    private PuntajesAltos unosPuntajes;

    private static Juego INSTANCE = null;

    public static Juego getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Juego ();
        }
        return INSTANCE;
    }
    private Juego(int DimensionGrillaX, int DimensionGrillaY ){
        // PEDIR DIMENSIONES POR PANTALLA??? -> si
      //  this.jugadores = new ArrayList<>();
        this.jugadores =  new LinkedList<>();
        Grilla grilla = Grilla.getInstance (DimensionGrillaX, DimensionGrillaY);
        grilla.generarUbicablesRandom ();
        grilla.generarMeta();
    }
    private Juego (){
        this.jugadores = new LinkedList<>();
    }

    public void agregarJugador (Jugador unJugador){
        this.jugadores.add (unJugador);
    }

    public void jugadorConTurnoActualMueveVehiculo (Direccion unaDireccion){
        Jugador unJugador =  this.jugadores.poll();
        try {
            unJugador.moverVehiculoHacia(unaDireccion);
        }catch (Exception e){
           this.jugadores.add(unJugador);
        }
        // Por ahora se define que el jugador pierde su turno si ocurre un error.
        this.jugadores.add(unJugador);
    }

}
