package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    // Singleton pattern

    private ArrayList <Jugador> jugadores = null;
    private PuntajesAltos unosPuntajes;

    private static Juego INSTANCE = null;

    public static Juego getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Juego ();
        }
        return INSTANCE;
    }
    private Juego(int DimensionGrillaX, int DimensionGrillaY ){
        // PEDIR DIMENSIONES POR PANTALLA???
        this.jugadores = new ArrayList<>();
        Grilla grilla = Grilla.getInstance (DimensionGrillaX, DimensionGrillaY);
        grilla.generarUbicablesRandom ();
        grilla.generarMeta();
    }
    private Juego (){
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador (Jugador unJugador){
        jugadores.add (unJugador);
    }

}
