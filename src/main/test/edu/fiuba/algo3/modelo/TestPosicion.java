package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.posicion.Posicion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPosicion {

    @Test
    public void seSumanLasCoordenadasDe2PosicionesYSeCompruebaElResultado () {
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,2);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicionSuma = posicion1.obtenerSumaDeCoordenadas (posicion2);
        assertTrue (posicionSuma.igualA(posicion3));
    }

}
