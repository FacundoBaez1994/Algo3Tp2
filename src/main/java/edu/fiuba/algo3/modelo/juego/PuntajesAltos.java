package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.archivador.Archivador;
import edu.fiuba.algo3.archivador.FormatoJson;
import edu.fiuba.algo3.modelo.grilla.Ubicable;

import java.io.IOException;
import java.util.*;

public class PuntajesAltos {
    private ArrayList<Jugador> jugadores = null;

    private Archivador archivador = null;
    public PuntajesAltos(){
       this.jugadores =  new ArrayList<>();
       this.archivador = new FormatoJson();
    }
    public void agregarJugador(Jugador unJugador) {
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
/*    public Map<String, Integer> obtenerPuntajesAltos(){
        Map<String, Integer> ranking = new HashMap<String, Integer>();
        for (int i = 0; i < 3; i++) {
           ranking.put(this.jugadores.get(i).getNickName(),this.jugadores.get(i).getPuntaje());
        }
        return ranking;
    }
*/
    public void importar(){
        this.jugadores = this.archivador.importar();
    }

    public void exportar() throws IOException {
        this.archivador.exportar(this.jugadores);
    }

    public ArrayList<Jugador> obtenerPuntajesAltos(){
        return this.jugadores;
    }

}
