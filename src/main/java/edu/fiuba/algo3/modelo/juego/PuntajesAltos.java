package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.grilla.Ubicable;

import java.util.*;

public class PuntajesAltos {
    private ArrayList<Jugador> jugadores = null;
    public PuntajesAltos(){
       this.jugadores =  new ArrayList<>();
    }
    public void agregarJugador(Jugador unJugador){
       jugadores.add(unJugador);
       this.ordenarPuntajes();
    }
    private void ordenarPuntajes(){
       Collections.sort(this.jugadores);
    }
    public Jugador obtenerJugadorConPuntajeMasAlto(){
        int numeroDePosicionDePuntajeMasAlto = 0;
        return this.jugadores.get(numeroDePosicionDePuntajeMasAlto);
    }



}
