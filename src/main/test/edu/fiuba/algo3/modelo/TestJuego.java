package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.LlegadaALaMeta;
import edu.fiuba.algo3.modelo.grilla.Grilla;
import edu.fiuba.algo3.modelo.grilla.Meta;
import edu.fiuba.algo3.modelo.grilla.Ubicable;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Arriba;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestJuego {

    @BeforeEach
    public void reiniciarSinglettons ()  {
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar ();
        Juego juego = Juego.getInstance();
        juego.reiniciar();
    }

    @Test
    public void SeIniciaElJuegoConDosJugadoresYElSegundoJugadorLlegaALaMeta() {
        Juego juego = Juego.getInstance();
        Jugador jugador1 = new Jugador("Carlitos", new Posicion(1,1));
        Jugador jugador2 = new Jugador("Celcius", new Posicion(1,3));
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Meta(new Posicion(3,3)));
        juego.jugadorConTurnoActualMueveVehiculo(new Derecha());
        Executable task = () -> {
            juego.jugadorConTurnoActualMueveVehiculo(new Derecha());
        };
        assertThrows (LlegadaALaMeta.class, task);
    }
    @Test
    public void SeIniciaElJuegoConTresJugadoresYUnJugadorAtraviesaUnPozoConUnaMoto() {
        Juego juego = Juego.getInstance();
        Jugador jugador1 = new Jugador("Carlitos", new Posicion(1,1));
        Jugador jugador2 = new Jugador("Celcius", new Posicion(1,3));
        Jugador jugador3 = new Jugador("Roberta", new Posicion(2,3));
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.agregarJugador(jugador3);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Pozo(new Posicion(1,2)));
        unaGrilla.agregarUbicable(new Pozo(new Posicion(3,3)));
        unaGrilla.agregarUbicable(new Pozo(new Posicion(3,3)));
        juego.jugadorConTurnoActualMueveVehiculo(new Arriba());
        assertEquals(jugador1.getPuntaje(),4);
    }
    @Test
    public void SeIniciaElJuegoConDosJugadoresYAvanzanALaDerechaDosVecesYEncuentranObstaculos() {
        Juego juego = Juego.getInstance();
        Jugador jugador1 = new Jugador("Carlitos", new Posicion(1,1));
        Jugador jugador2 = new Jugador("Celcius", new Posicion(1,3));

        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);

        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Pozo(new Posicion(2,1)));
        unaGrilla.agregarUbicable(new Piquete(new Posicion(2,3)));

        for(int i=0; i < 4; i++){
           juego.jugadorConTurnoActualMueveVehiculo(new Derecha());
        }
        assertEquals(jugador1.getPuntaje(),5);
        assertEquals(jugador2.getPuntaje(),4);
        assertTrue(jugador1.getVehiculo().estaEnPosicion(new Posicion(5,1)));
        assertTrue(jugador2.getVehiculo().estaEnPosicion(new Posicion(5,3)));
    }

}
