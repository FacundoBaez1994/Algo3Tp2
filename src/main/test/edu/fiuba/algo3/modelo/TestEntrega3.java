package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import edu.fiuba.algo3.modelo.excepciones.LlegadaALaMeta;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Derecha;
import edu.fiuba.algo3.modelo.movimiento.direcciones.Direccion;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Random;


public class TestEntrega3 {

    @BeforeEach
    public void reiniciarTablero ()  {
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.reiniciar ();
    }

    @Test
    public void UnaMotoAtraviesaLaCiudadYSeEncuentraConLaMeta () {
        Direccion unaDireccion = new Derecha();
        Posicion unaPosicion = new Posicion(0,0);
        Vehiculo unaMoto = new Vehiculo (new Moto() , unaPosicion);
        Grilla unaGrilla = Grilla.getInstance();
        unaGrilla.agregarUbicable(new Meta (new Posicion(2,0)));

        Executable task = () -> {
            unaMoto.moverseHacia (unaDireccion);
        };

        assertThrows (LlegadaALaMeta.class, task);
    }

    @Test
    public void SeGeneraControlPolicialEnUnPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.2);

            Ubicable unObstaculo = mockedGrilla.generarObstaculoRandomEn (new Posicion(3,3));

            assertTrue(unObstaculo.getClass().equals(((new ControlPolicial()).getClass())));
            assertTrue(unObstaculo.estaEnPosicion(new Posicion(3,3)));
        }
    }
    @Test
    public void SeGeneraUnPiqueteEnUnPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.5);

            Ubicable unObstaculo = mockedGrilla.generarObstaculoRandomEn (new Posicion(4,5));

            assertTrue(unObstaculo.getClass().equals(((new Piquete()).getClass())));
            assertTrue(unObstaculo.estaEnPosicion(new Posicion(4,5)));}
    }

    @Test
    public void SeGeneraUnPozoEnUnPosicionDeLaGrilla () {
        try (MockedStatic<Grilla> mocked = mockStatic(Grilla.class)) {
            Grilla mockedGrilla = spy (Grilla.class);
            mocked.when(Grilla::getInstance).thenReturn(mockedGrilla);
            when(mockedGrilla.generarNumeroRandom()).thenReturn(0.9);

            Ubicable unObstaculo = mockedGrilla.generarObstaculoRandomEn (new Posicion(6,7));

            assertTrue(unObstaculo.getClass().equals(((new Pozo()).getClass())));
            assertTrue(unObstaculo.estaEnPosicion(new Posicion(6,7)));}
    }

}
