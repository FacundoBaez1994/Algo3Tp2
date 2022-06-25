package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.archivador.Archivador;
import edu.fiuba.algo3.modelo.grilla.Ubicable;

import java.io.IOException;
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

    public void importar(Archivador manejadorArchivos){
        this.jugadores = manejadorArchivos.importar();
    }

    public void exportar(Archivador manejadorArchivos) throws IOException {
        manejadorArchivos.exportar(this.jugadores);
    }



}
