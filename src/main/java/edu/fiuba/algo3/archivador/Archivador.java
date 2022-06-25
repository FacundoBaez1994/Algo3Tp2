package edu.fiuba.algo3.archivador;

import edu.fiuba.algo3.modelo.juego.Jugador;

import java.io.IOException;
import java.util.ArrayList;

public interface Archivador {
    public abstract ArrayList<Jugador> importar();
    public abstract void exportar(ArrayList<Jugador> jugadores) throws IOException;
}
