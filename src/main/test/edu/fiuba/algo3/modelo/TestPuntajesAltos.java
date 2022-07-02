package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.PuntajesAltos;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPuntajesAltos {

    @Test
    public void SeSeteanVariosJugadoresConPuntajesYSeVerificaElMaximo() {

        Jugador jugador1 = new Jugador("LuisFernando", 10);
        Jugador jugador2 = new Jugador("Roberta", 100);
        Jugador jugador3 = new Jugador("JeffBezos", 3);
        Jugador jugador4 = new Jugador("EduardoMusk", 67);
        Jugador jugador5 = new Jugador("BilardoGates", 36);
        Jugador jugador6 = new Jugador("MarkosZukenberka", 19);
        Jugador jugador7 = new Jugador("JuanKelly", 2);
        Jugador jugador8 = new Jugador("ElComandante", 4); // Por Ricky Fort

        PuntajesAltos puntajesAltos = new PuntajesAltos();
        puntajesAltos.agregarJugador(jugador1);
        puntajesAltos.agregarJugador(jugador2);
        puntajesAltos.agregarJugador(jugador3);
        puntajesAltos.agregarJugador(jugador4);
        puntajesAltos.agregarJugador(jugador5);
        puntajesAltos.agregarJugador(jugador6);
        puntajesAltos.agregarJugador(jugador7);
        puntajesAltos.agregarJugador(jugador8);

        assertEquals(puntajesAltos.obtenerJugadorConPuntajeMasAlto().getNickname(), "JuanKelly");

    }
}
